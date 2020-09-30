/***********************************************************************
 * Module:  Joueur.java
 * Author:  Lenovo
 * Purpose: Defines the Class Joueur
 ***********************************************************************/

package model;

import java.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** @pdOid 760a70c6-1461-406f-ae4e-bef83bc852f3 */
public class Joueur extends Personne {
	public Joueur() {
		// TODO: implement
		this.idPersonne = 0;
	}

	/** @param joueur
	 * @pdOid 4d887337-37fe-4116-9b86-da51c1ebe309 */
	public static boolean save(Joueur joueur) {
		// TODO: implement
		if(joueur == null)
			return false;

		int row_count = 0;
		try{
			boolean newJoueur = false;
			String sql;
			if(joueur.getIdPersonne() <= 0){
				sql = "INSERT INTO personne (numero_licence, date_licence, nom, prenom, photo, date_naissance, idpays_naissance)" 
						+ " VALUES (" 
						+ Util.addQuotes(joueur.getLicence()) + ", "
						+ Util.addQuotes(joueur.getDateAcquisition()) + ", "
						+ Util.addQuotes(joueur.getNom()) + ", "
						+ Util.addQuotes(joueur.getPrenom()) + ", "
						+ Util.addQuotes(joueur.getPhoto()) + ", "
						+ Util.addQuotes(joueur.getDateNaissance()) + ", ";
				sql += (joueur.getLieuNaiss() == null)? "null" : "" + joueur.getLieuNaiss().getIdPays();
				sql += ")";	
				newJoueur = true;
			}
			else{
				sql = "UPADTE personne SET "
						+ "numero_licence=" + Util.addQuotes(joueur.getLicence()) + ", "
						+ "date_licence=" + Util.addQuotes(joueur.getDateAcquisition()) + ", "
						+ "nom=" + Util.addQuotes(joueur.getNom()) + ", "
						+ "prenom=" + Util.addQuotes(joueur.getPrenom()) + ", "
						+ "photo=" + Util.addQuotes(joueur.getPhoto()) + ", "
						+ "date_naissance=" + Util.addQuotes(joueur.getDateNaissance()) + ", "
						+ "idpays_naissance=" + ((joueur.getLieuNaiss() == null)? "null" : "" + joueur.getLieuNaiss().getIdPays())
						+ " WHERE idpersonne = " + joueur.getIdPersonne();
			}

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/championnat?user=root&password=");
			// Mode transactional
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			row_count = stmt.executeUpdate(sql);

			int idjoueur = 0;
			if(row_count > 0){
				if(newJoueur){
					ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
					if(rs.next()){
						idjoueur = rs.getInt(1);
						sql = "INSERT INTO joueur (idjoueur) VALUES (" + idjoueur + ")";
						row_count = stmt.executeUpdate(sql);
					}
					else
						row_count = 0;
				}
				else
					idjoueur = joueur.getIdPersonne();

				if(row_count > 0){
					for(Pays pays : joueur.getPays()){
						sql = "INSERT INTO nationalites (idpays, idpersonne) VALUES (" + pays.getIdPays() + ", " + idjoueur 
								+ ") ON DUPLICATE KEY UPDATE idpersonne=" + idjoueur;
						row_count = stmt.executeUpdate(sql);
						if(row_count == 0)
							break;
					}
				}
			}
			else
				row_count = 0;

			if(row_count > 0)
				conn.commit(); // Validation des opérations de la transaction
			else
				conn.rollback(); // Annulation des opérations

			stmt.close();
			conn.close();
		}
		catch(Exception exc){
			return false;
		}

		return (row_count > 0);
	}

	/** @param joueur
	 * @pdOid a60a959c-53cb-474c-b4bc-6cdfc3695936 */
	public static boolean delete(Joueur joueur) {
		// TODO: implement
		return false;
	}

	/** @pdOid 1e94d9ac-2f06-4829-983b-7d5e05ddfe49 */
	public static Joueur newJoueur() {
		// TODO: implement
		Joueur joueur = new Joueur();
		return joueur;
	}

	/** @pdOid 7f549921-d8f5-4ac7-9bad-abcbd532db5e */
	public static Vector<Joueur> getJoueurs() {
		// TODO: implement
		String sql = "SELECT idpersonne, numero_licence, date_licence, nom, prenom, photo, " 
				+ "date_naissance, IFNULL(idpays_naissance, 0) AS idpays_naissance " 
				+ "FROM personne WHERE idpersonne IN "
				+ "(SELECT idjoueur FROM joueur)";
		Vector<Joueur> joueurs = Joueur.getJoueurs(sql);
		return joueurs;
	}

	public static Vector<Joueur> getJoueurs(Equipe equipe){
		if(equipe == null)
			return null;
		
		Saison saison = Saison.getLastSaison();
		if(saison == null)
			return null;
		
		Vector<Joueur> joueurs = Joueur.getJoueurs(equipe, saison);
		return joueurs;
	}
	
	/** @param equipe 
	 * @param saison
	 * @pdOid 903908c1-092e-430f-bc04-cab25e1a85d0 */
	public static Vector<Joueur> getJoueurs(Equipe equipe, Saison saison) {
		// TODO: implement
		if(saison == null || equipe == null)
			return null;

		String sql = "SELECT idpersonne, numero_licence, date_licence, nom, prenom, photo, " 
				+ "date_naissance, IFNULL(idpays_naissance, 0) AS idpays_naissance " 
				+ "FROM personne WHERE idpersonne IN "
				+ "(SELECT idjoueur FROM joueur)"
				+ " AND idpersonne IN "
				+ "(select idpersonne FROM contrat WHERE (idequipe=" + equipe.getIdEquipe() + ")"
				+ " AND idcontrat IN ("
				+ "select idcontrat from contrat_saison WHERE idsaison = " 
				+ saison.getAnnee() + "))";
		Vector<Joueur> joueurs = Joueur.getJoueurs(sql);
		return joueurs;
	}

	/** @param saison
	 * @pdOid 0567cf7a-f7f9-4ece-b2b5-952e569efb8c */
	public static Vector<Joueur> getJoueurs(Saison saison) {
		// TODO: implement
		if(saison == null)
			return null;

		String sql = "SELECT idpersonne, numero_licence, date_licence, nom, prenom, photo, " 
				+ "date_naissance, IFNULL(idpays_naissance, 0) AS idpays_naissance "
				+ "FROM personne WHERE idpersonne IN "
				+ "(SELECT idjoueur FROM joueur) "
				+ "AND idpersonne IN "
				+ "(select idpersonne FROM contrat WHERE idcontrat IN ("
				+ "select idcontrat from contrat_saison WHERE idsaison = " 
				+ saison.getAnnee() + "))";
		Vector<Joueur> joueurs = Joueur.getJoueurs(sql);
		return joueurs;
	}

	/** @param idJoueur
	 * @pdOid 3b74306b-ec7e-464f-9928-f5a82bfb5855 */
	public static Joueur getJoueur(int idJoueur) {
		String sql = "SELECT idpersonne, numero_licence, date_licence, nom, prenom, photo, " 
				+ "date_naissance, IFNULL(idpays_naissance, 0) AS idpays_naissance " 
				+ "FROM personne WHERE idpersonne IN "
				+ "(SELECT idjoueur FROM joueur WHERE idJoueur = " + idJoueur + ")";
		Vector<Joueur> joueurs = Joueur.getJoueurs(sql);

		if(joueurs == null || joueurs.size()==0)
			return null;
		return joueurs.get(0);
	}

	protected static Vector<Joueur> getJoueurs(String sql) {
		// TODO: implement
		Vector<Joueur> joueurs = new Vector<Joueur>();
		Joueur joueur;

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = java.sql.DriverManager.getConnection(
					"jdbc:mysql://localhost/championnat?user=root&password=");
			System.out.println("Connection à la base données ...!!");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				joueur = new Joueur();
				joueur.setNom(rs.getString("nom"));
				joueur.setPrenom(rs.getString("prenom"));
				joueur.setPhoto(rs.getString("photo"));
				joueur.setLicence(rs.getString("numero_licence"));
				joueur.setDateNaissance(rs.getDate("date_naissance"));
				joueur.setDateAcquisition(rs.getDate("date_licence"));				
				joueur.setLieuNaiss(Pays.getPays(rs.getInt("idpays_naissance")));

				// Nationalités
				// ??

				joueurs.add(joueur);
			}

			rs.close();
			stmt.close();
			conn.close();

		}
		catch(Exception e){}

		return joueurs;
	}

}