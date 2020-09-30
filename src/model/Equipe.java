/***********************************************************************
 * Module:  Equipe.java
 * Author:  Lenovo
 * Purpose: Defines the Class Equipe
 ***********************************************************************/

package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/** @pdOid bdb3220b-4c5d-4ef4-84d2-01a96cc012f8 */
public class Equipe {
	/** @pdOid 48249c3e-23da-4c0c-8f3c-1c04493cc405 */
	private String nom;
	/** @pdOid 7cdb9e51-83e6-47de-976e-8cf473e8e42e */
	private String rgbColorDom1;
	/** @pdOid b0b2e092-8272-4ba6-9bc5-490fd1b9201f */
	private String rgbColorDom2;
	/** @pdOid 9a0a905e-2a59-4bf5-a40d-f1fd8ac580ff */
	private String rgbColorExt1;
	/** @pdOid 63556690-691c-4aab-973d-78fc43e4156c */
	private String rgbColorExt2;

	/** @pdRoleInfo migr=no name=Stade assc=equipeStade mult=1..1 side=A */
	protected Stade stade;

	/** @pdOid 4fcd1366-1db4-4e24-abc7-99b9a9411226 */
	protected void finalize() {
		// TODO: implement
	}

	/** @param equipe
	 * @pdOid 11b84680-0a00-4f5b-9e13-24007c5c0171 */
	public static boolean save(Equipe equipe) {
		// TODO: implement
		if(equipe == null)
			return false;

		int row_count = 0;
		try{
			String sql;
			if(equipe.getIdEquipe() <= 0){
				sql = "INSERT INTO equipe (nom, couleur_domicile1, couleur_domicile2, " 
						+ "couleur_exterieure1, couleur_exterieure2, idstade)" 
						+ " VALUES (" 
						+ Util.addQuotes(equipe.getNom()) + ", "
						+ Util.addQuotes(equipe.getRgbColorDom1()) + ", "
						+ Util.addQuotes(equipe.getRgbColorDom2()) + ", "
						+ Util.addQuotes(equipe.getRgbColorExt1()) + ", "
						+ Util.addQuotes(equipe.getRgbColorExt2()) + ", ";
				sql += (equipe.stade == null)? "null" : "" + equipe.stade.getIdStade();
				sql += ")";	
			}
			else{
				sql = "UPADTE equipe SET "
						+ "nom=" + Util.addQuotes(equipe.getNom()) + ", "
						+ "couleur_domicile1=" + Util.addQuotes(equipe.getRgbColorDom1()) + ", "
						+ "couleur_domicile2=" + Util.addQuotes(equipe.getRgbColorDom2()) + ", "
						+ "couleur_exterieure1=" + Util.addQuotes(equipe.getRgbColorExt1()) + ", "
						+ "couleur_exterieure2=" + Util.addQuotes(equipe.getRgbColorExt2()) + ", "
						+ "idstade=" + ((equipe.stade == null)? "null" : "" + equipe.stade.getIdStade())
						+ " WHERE idequipe = " + equipe.getIdEquipe();
			}

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/championnat?user=root&password=");
			// Mode non transactional
			conn.setAutoCommit(true);
			Statement stmt = conn.createStatement();
			row_count = stmt.executeUpdate(sql);

			stmt.close();
			conn.close();
		}
		catch(Exception exc){
			return false;
		}

		return (row_count > 0);
	}

	/** @param equipe
	 * @pdOid 5fd25c9b-f1a0-4768-a539-13665165cc1e */
	public static boolean delete(Equipe equipe) {
		// TODO: implement
		return false;
	}

	/** @pdOid 55bef6f8-81eb-493d-8b13-f5c851918b68 */
	int idEquipe;
	/** Objet modifi√© et pas encore enregistr√© ou pas
	 * 
	 * @pdOid 9d56e679-04c9-421e-b0c7-2fde7fae53d2 */
	boolean updated = false;

	/** @pdOid c0176c20-d2a7-48ab-8731-577032d487c8 */
	public Equipe() {
		// TODO: implement
		this.idEquipe = 0;
	}

	/** @pdOid e679f550-46aa-4fd0-878f-01ccd89943c8 */
	public int getIdEquipe() {
		return idEquipe;
	}

	/** @pdOid ebd033d7-69c1-4408-b028-0266e420536e */
	public String getNom() {
		return nom;
	}

	/** @param newNom
	 * @pdOid 5b375e6a-8ecb-442d-aaf0-71eea430c9d3 */
	public void setNom(String newNom) {
		nom = newNom;
	}

	/** @pdOid ac651ec8-1d95-4f8d-b246-3a0c0f0c7133 */
	public String getRgbColorDom1() {
		if(Util.isEmptyOrNull(rgbColorDom1))
			return "000";
		return rgbColorDom1;
	}

	/** @param newRgbColorDom1
	 * @pdOid 52d820c2-2f48-46ee-a613-e34045c75927 */
	public void setRgbColorDom1(String newRgbColorDom1) {
		rgbColorDom1 = newRgbColorDom1;
	}

	/** @pdOid 96976e30-a3f9-4ac8-851b-3aaf3faed01d */
	public String getRgbColorDom2() {
		if(Util.isEmptyOrNull(rgbColorDom2))
			return "000";
		return rgbColorDom2;
	}

	/** @param newRgbColorDom2
	 * @pdOid 85909e31-3be8-490b-b4cc-8b09fc2885d5 */
	public void setRgbColorDom2(String newRgbColorDom2) {
		rgbColorDom2 = newRgbColorDom2;
	}

	/** @pdOid c49863f7-f211-4a7f-bfed-03f495556a4b */
	public String getRgbColorExt1() {
		if(Util.isEmptyOrNull(rgbColorExt1))
			return "000";
		return rgbColorExt1;
	}

	/** @param newRgbColorExt1
	 * @pdOid b0e675bf-119f-406d-a900-79fd00bca151 */
	public void setRgbColorExt1(String newRgbColorExt1) {
		rgbColorExt1 = newRgbColorExt1;
	}

	/** @pdOid d7120322-c79a-4d0a-9887-3facfb2bb899 */
	public String getRgbColorExt2() {
		if(Util.isEmptyOrNull(rgbColorExt2))
			return "000";
		return rgbColorExt2;
	}

	/** @param newRgbColorExt2
	 * @pdOid 479678a2-9a3d-478e-885c-0ef876aaa2b5 */
	public void setRgbColorExt2(String newRgbColorExt2) {
		rgbColorExt2 = newRgbColorExt2;
	}

	public Stade getStade(){
		return this.stade;
	}

	public void setStade(Stade stade){
		this.stade = stade;
	}

	/** @pdOid ccd8b06e-5156-45b2-a2f8-187f46fe5e85 */
	public String toString() {
		return this.nom;
	}

	/** @pdOid aee4a149-bed8-4e98-a0ec-54e47087d7bd */
	public static Equipe newEquipe() {
		// TODO: implement
		Equipe equipe =  new Equipe();
		return equipe;
	}

	public static Vector<Equipe> getEquipes(Saison saison) {
		// TODO: implement
		if(saison == null)
			return null;

		String sql = "SELECT idequipe, nom, couleur_domicile1, couleur_domicile2, " 
				+ "couleur_exterieure1, couleur_exterieure2, IFNULL(idstade, 0) AS idstade "
				+ " FROM equipe WHERE idequipe IN "
				+ "(SELECT idequipe FROM competir WHERE idsaison=" + saison.getAnnee() + ")";

		Vector<Equipe> equipes = Equipe.getEquipes(sql);
		return equipes;
	}

	/** @pdOid 3394f7b1-74a8-46d3-a4cb-44c2c96ef309 */
	public static Vector<Equipe> getEquipes() {
		// TODO: implement
		String sql = "SELECT idequipe, nom, couleur_domicile1, couleur_domicile2, " 
				+ "couleur_exterieure1, couleur_exterieure2, IFNULL(idstade, 0) AS idstade "
				+ " FROM equipe";

		Vector<Equipe> equipes = Equipe.getEquipes(sql);
		return equipes;
	}

	/** @pdOid 3850be19-e019-492c-ab8b-103e3ee2ef71 */
	public static Equipe getEquipe(int idEquipe) {
		// TODO: implement
		String sql = "SELECT idequipe, nom, couleur_domicile1, couleur_domicile2, " 
				+ "couleur_exterieure1, couleur_exterieure2, IFNULL(idstade, 0) AS idstade "
				+ " FROM equipe WHERE idequipe=" + idEquipe;

		Vector<Equipe> equipes = Equipe.getEquipes(sql);
		if(equipes == null || equipes.size()==0)
			return null;
		return equipes.get(0);
	}

	protected static Vector<Equipe> getEquipes(String sql){
		// TODO: implement
		Vector<Equipe> equipes = new Vector<Equipe>();
		Equipe equipe;

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = java.sql.DriverManager.getConnection(
					"jdbc:mysql://localhost/championnat?user=root&password=");
			System.out.println("Connection ‡ la base donnÈes ...!!");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// idequipe 	nom 	couleur_domicile1 	couleur_domicile2 	couleur_exterieure1 	couleur_exterieure2 	idstade 
			Hashtable<Integer, Stade> stades = new Hashtable<Integer, Stade>();
			while(rs.next()){
				equipe = new Equipe();
				equipe.idEquipe = rs.getInt("idequipe");
				equipe.setNom(rs.getString("nom"));
				equipe.setRgbColorDom1(rs.getString("couleur_domicile1"));
				equipe.setRgbColorDom2(rs.getString("couleur_domicile2"));
				equipe.setRgbColorExt1(rs.getString("couleur_exterieure1"));
				equipe.setRgbColorExt2(rs.getString("couleur_exterieure2"));
				Integer idStade = new Integer(rs.getInt("idstade"));
				if(stades.containsKey(idStade))
					equipe.stade = stades.get(idStade);
				else
					equipe.stade = Stade.getStade(idStade.intValue());

				equipes.add(equipe);
			}

			stades.clear();
			rs.close();
			stmt.close();
			conn.close();

		}
		catch(Exception e){}

		return equipes;
	}
}