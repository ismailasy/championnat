/***********************************************************************
 * Module:  Stade.java
 * Author:  Lenovo
 * Purpose: Defines the Class Stade
 ***********************************************************************/

package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/** @pdOid f0eea013-5288-4d27-874d-a46f2cba93e6 */
public class Stade {
   /** @pdOid efdcf35f-b09a-42f1-b659-bf4c46cfc016 */
   private String nom;
   /** @pdOid 22ff923c-f421-4474-a4c1-840f58bd1214 */
   private int capacite;
   
   /** @pdRoleInfo migr=no name=Ville assc=villeStade mult=1..1 side=A */
   protected Ville ville;
   
   /** @pdOid 21aba586-4cb4-49a3-9fa0-7fe8376cc552 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdOid c83b026e-3eb4-42ed-a54e-6aeaac56e73e */
   int idStade;
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid 0939d962-70b5-4b63-8e02-8cbb814b7b26 */
   boolean updated = false;
   
   /** @pdOid eec6a541-30c3-4a3e-8a1f-2502b648eca0 */
   public Stade() {
      // TODO: implement
      this.idStade = 0;
   }
   
   /** @pdOid 9e8f943e-2774-4ec1-875c-8a98acd8dcbc */
   public int getIdStade() {
      return idStade;
   }
   
   /** @pdOid 5196873c-b27b-4e2b-843c-0d9d75b3b41a */
   public String getNom() {
      return nom;
   }
   
   /** @param newNom
    * @pdOid 97edf0b6-f956-411a-9d1f-7bafd0fae8aa */
   public void setNom(String newNom) {
      nom = newNom;
      updated = true;
   }
   
   /** @pdOid a690adfa-ae65-4675-831a-d31805a7e9a3 */
   public int getCapacite() {
      return capacite;
   }
   
   /** @param newCapacite
    * @pdOid 808ffea7-f53f-4412-b352-f265c9609774 */
   public void setCapacite(int newCapacite) {
      capacite = newCapacite;
      updated = true;
   }
   
   public Ville getVille(){
	   return ville;
   }
   
   public void setVille(Ville ville){
	   this.ville = ville;
   }
   
   /** @pdOid 0370e05c-7d7d-47f5-9244-04dec23efa25 */
   public String toString() {
      return this.nom;
   }
   
   public static Stade getStade(int idStade){
	   String sql = "SELECT idstade, IFNULL(idville, 0) AS idville, nom, capacite FROM stade WHERE idstade=" + idStade;
	   Vector<Stade> stades = Stade.getStades(sql);
	   
	   if(stades == null || stades.isEmpty())
		   return null;
	   return stades.get(0);
   }
   
   public static Vector<Stade> getStades(){
	   String sql = "SELECT idstade, IFNULL(idville, 0) AS idville, nom, capacite FROM stade";
	   return Stade.getStades(sql);
   }
   
   protected static Vector<Stade> getStades(String sql){
	   Vector<Stade> stades = new Vector<Stade>();
		Stade stade;
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = java.sql.DriverManager.getConnection(
					"jdbc:mysql://localhost/championnat?user=root&password=");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				stade = new Stade();
				stade.idStade = rs.getInt("idstade");
				Ville ville = Ville.getVille(rs.getInt("idville"));
				stade.setVille(ville);
				stade.setNom(rs.getString("nom"));	
				stade.setCapacite(rs.getInt("capacite"));
				stades.add(stade);
			}

			rs.close();
			stmt.close();
			conn.close();

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return stades;
   }
}