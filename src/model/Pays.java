/***********************************************************************
 * Module:  Pays.java
 * Author:  Lenovo
 * Purpose: Defines the Class Pays
 ***********************************************************************/

package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/** @pdOid 3c1d1ed5-9de8-49df-8ace-744c8687c539 */
public class Pays {
   /** @pdOid aa9d6042-8489-47c6-b327-557a2f53c8e0 */
   private String nom;
   
   /** @pdOid 85e9fb59-4df5-4600-8486-fe3d4a627769 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdOid ccbfa691-de32-4825-b5fa-da8adba534d7 */
   int idPays;
   /** Objet modifi√© et pas encore enregistr√© ou pas
    * 
    * @pdOid 17fbcd7a-a8e1-4ef9-bedf-29778d35fad9 */
   boolean updated = false;
   
   /** @pdOid 521492a4-0aeb-4764-b77c-60026b6411f5 */
   public Pays() {
      // TODO: implement
   }
   
   /** @pdOid 0b936f1a-63f5-4063-b661-7a97ba17c9ec */
   public int getIdPays() {
      return idPays;
   }
   
   /** @pdOid 9590dae8-6384-4729-a5d6-35cbd064f1e1 */
   public String getNom() {
      return nom;
   }
   
   /** @param newNom
    * @pdOid 8cf1df7f-c37b-4423-9f15-2ca9ac0b2f0a */
   public void setNom(String newNom) {
      nom = newNom;
   }
   
   /** @pdOid bbbf93a1-75c1-4f01-8c73-e31aff8495cb */
   public String toString() {
      return this.nom;
   }
   
   /** @param Pays
	 * @pdOid 4d887337-37fe-4116-9b86-da51c1ebe309 */
	protected static boolean save(Pays pays) {
		// TODO: implement
		return false;
	}

	/** @param joueur
	 * @pdOid a60a959c-53cb-474c-b4bc-6cdfc3695936 */
	protected static boolean delete(Pays pays) {
		// TODO: implement
		return false;
	}

	/** @pdOid 1e94d9ac-2f06-4829-983b-7d5e05ddfe49 */
	public static Pays newJoueur() {
		// TODO: implement
		Pays pays = new Pays();
		return pays;
	}
	
	public static Pays getPays(int idPays) {
		String sql = "SELECT idpays, nom FROM pays WHERE idpays=" + idPays;
		Vector<Pays> vpays = Pays.getPays(sql);
		
		if(vpays == null || vpays.size()==0)
			return null;
		return vpays.get(0);
	}

	public static Vector<Pays> getPays() {
		String sql = "SELECT idpays, nom FROM pays";
		Vector<Pays> vpays = Pays.getPays(sql);		
		return vpays;
	}
	
	protected static Vector<Pays> getPays(String sql) {
		// TODO: implement
		Vector<Pays> vpays = new Vector<Pays>();
		Pays pays;
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = java.sql.DriverManager.getConnection(
					"jdbc:mysql://localhost/championnat?user=root&password=");
			System.out.println("Connection ‡ la base donnÈes ...!!");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				pays = new Pays();
				pays.idPays = rs.getInt("idpays");
				pays.setNom(rs.getString("nom"));				
				vpays.add(pays);
			}

			rs.close();
			stmt.close();
			conn.close();

		}
		catch(Exception e){}
		
		return vpays;
	}

}