/***********************************************************************
 * Module:  Journee.java
 * Author:  Lenovo
 * Purpose: Defines the Class Journee
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid c74113ce-daf5-44d3-8323-d45fc6d00775 */
public class Journee {
   /** @pdOid 4212afff-57b2-45f1-825f-72f75067e21d */
   private int numero;
   
   /** @pdRoleInfo migr=no name=Match assc=jouneeMatchs coll=java.util.List impl=java.util.ArrayList mult=1..* type=Aggregation */
   protected java.util.List<Match> match;
   /** @pdRoleInfo migr=no name=Saison assc=saisonJournees mult=1..1 side=A */
   protected Saison saison;
   
   /** @pdOid d7ff669a-d3ed-4dff-9dd5-59142da29f73 */
   protected void finalize() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Match> getMatch() {
      if (match == null)
         match = new java.util.ArrayList<Match>();
      return match;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMatch() {
      if (match == null)
         match = new java.util.ArrayList<Match>();
      return match.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMatch */
   public void setMatch(java.util.List<Match> newMatch) {
      removeAllMatch();
      for (java.util.Iterator iter = newMatch.iterator(); iter.hasNext();)
         addMatch((Match)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMatch */
   public void addMatch(Match newMatch) {
      if (newMatch == null)
         return;
      if (this.match == null)
         this.match = new java.util.ArrayList<Match>();
      if (!this.match.contains(newMatch))
      {
         this.match.add(newMatch);
         newMatch.setJournee(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldMatch */
   public void removeMatch(Match oldMatch) {
      if (oldMatch == null)
         return;
      if (this.match != null)
         if (this.match.contains(oldMatch))
         {
            this.match.remove(oldMatch);
            oldMatch.setJournee((Journee)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMatch() {
      if (match != null)
      {
         Match oldMatch;
         for (java.util.Iterator iter = getIteratorMatch(); iter.hasNext();)
         {
            oldMatch = (Match)iter.next();
            iter.remove();
            oldMatch.setJournee((Journee)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Saison getSaison() {
      return saison;
   }
   
   /** @pdGenerated default parent setter
     * @param newSaison */
   public void setSaison(Saison newSaison) {
      if (this.saison == null || !this.saison.equals(newSaison))
      {
         if (this.saison != null)
         {
            Saison oldSaison = this.saison;
            this.saison = null;
            oldSaison.removeJournees(this);
         }
         if (newSaison != null)
         {
            this.saison = newSaison;
            this.saison.addJournees(this);
         }
      }
   }
   
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid 52b1a74a-d465-42bb-8284-629db85820b1 */
   boolean updated = false;
   
   /** @param saison
    * @pdOid 3199c9a5-80fe-4642-997d-a746f46cba24 */
   public Journee(Saison saison) {
      this.setSaison(saison);
   }
   
   /** @pdOid 6cb01ece-b314-4368-913b-efa22d041453 */
   public int getNumero() {
      return numero;
   }
   
   /** @param newNumero
    * @pdOid 92257b88-4b06-4c64-9f35-7ab8b44923e3 */
   public void setNumero(int newNumero) {
      numero = newNumero;
   }
   
   /** @pdOid 08dc7a8d-5e50-4c8e-9632-544a88e40c40 */
   public String toString() {
      return "" + this.numero;
   }
   
   /** @pdOid 4ed24c65-26a0-4379-b69b-e4e29dbe078f */
   public static Journee[] getJournees() {
      // TODO: implement
      return null;
   }
   
   /** @param saison
    * @pdOid b7b6f77c-e41a-4379-b309-340dcbf5769f */
   public static Journee[] getJournees(Saison saison) {
      // TODO: implement
      return null;
   }
   
   /** @param saison 
    * @param numero
    * @pdOid ca52d14f-d055-48e1-ae5e-b7b0350831b6 */
   public static Journee getJournee(Saison saison, int numero) {
      // TODO: implement
      return null;
   }

}