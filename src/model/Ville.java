/***********************************************************************
 * Module:  Ville.java
 * Author:  Lenovo
 * Purpose: Defines the Class Ville
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid a46bb78c-1e3c-45ea-a2c3-3657840bbf89 */
public class Ville {
   /** @pdOid 9be33a2e-07a9-4dfd-8835-5ee584d47b50 */
   private String nom;
   /** @pdOid 00240540-6f4c-419c-b9e9-3540e6edf216 */
   private int nbHbts;
   
   /** @pdOid d8c7d05e-2792-4f60-8857-fed389a0354b */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdOid a1cfa2d3-a647-4f2a-a442-196bafddfc83 */
   int idVille;
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid 3c7fc392-47b4-4366-9e0d-06688f61a28b */
   boolean updated = false;
   
   /** @pdOid d2c5f20b-5d02-4b72-9f14-a77af722ae57 */
   public Ville() {
      // TODO: implement
   }
   
   /** @pdOid b1c20bfa-4385-4359-967a-c597ceca05f5 */
   public int getIdVille() {
      return idVille;
   }
   
   /** @pdOid 943a2017-0cc2-42aa-b6fb-25d8816bbb9c */
   public String getNom() {
      return nom;
   }
   
   /** @param newNom
    * @pdOid 666602be-82da-45db-81ea-0e1d01a33a76 */
   public void setNom(String newNom) {
      nom = newNom;
   }
   
   /** @pdOid c1deca24-c52b-47ac-840c-dc227ebafc22 */
   public int getNbHbts() {
      return nbHbts;
   }
   
   /** @param newNbHbts
    * @pdOid e1353a0a-27d0-4e85-8f25-f48c5139b7c5 */
   public void setNbHbts(int newNbHbts) {
      nbHbts = newNbHbts;
   }
   
   /** @pdOid 062e2c7f-4d6e-4f9f-884e-3f2c754cadeb */
   public String toString() {
      return this.nom;
   }

   public static Ville getVille(int idVille){
	   return null;
   }
}