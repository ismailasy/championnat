/***********************************************************************
 * Module:  Contrat.java
 * Author:  Lenovo
 * Purpose: Defines the Class Contrat
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 0d4d477e-1f90-4eae-9c34-2ff261bf840c */
public class Contrat {
   /** @pdOid 645bc905-c17f-488c-960a-08b4139aeedf */
   private int idContrat;
   /** @pdOid 1d2e60e7-2429-4f35-a843-f08086c8f97f */
   private Date dateSignature;
   
   /** @pdRoleInfo migr=no name=Personne assc=association20 mult=1..1 */
   protected Personne membre;
   
   /** @pdOid 56ae4505-d54c-4f3a-b17d-8161ac836afb */
   protected void finalize() {
      // TODO: implement
   }
   
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid 0449284c-f834-4175-adf0-8ec0ca16ae49 */
   boolean updated = false;
   
   public Maillot[] association21;
   /** @pdRoleInfo migr=no name=Equipe assc=association19 mult=1..1 side=A */
   public Equipe equipe;
   
   /** @param equipe 
    * @param personne 
    * @param dateSignature
    * @pdOid 17804986-10bb-4dcd-8f0f-154d7609e93e */
   public Contrat(Equipe equipe, Personne personne, Date dateSignature) {
      // TODO: implement
   }
   
   /** @param saison
    * @pdOid f1369e6f-f780-4812-b436-9c5fe93cc204 */
   public void addSaison(Saison saison) {
      // TODO: implement
   }
   
   /** @pdOid 3506c207-c726-4c02-90bb-dc716e03f843 */
   public String toString() {
      return "" + this.dateSignature;
   }

}