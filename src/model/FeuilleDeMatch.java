/***********************************************************************
 * Module:  FeuilleDeMatch.java
 * Author:  Lenovo
 * Purpose: Defines the Class FeuilleDeMatch
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 2ec795c1-6696-40e6-87ca-342b788b6143 */
public class FeuilleDeMatch {
   /** @pdOid f7f82ce3-ad39-4d65-b701-11655272dc0c */
   private int idFeuilleDeMatch;
   /** @pdOid 04a32fda-2bde-4be9-8f4c-19361887d8e5 */
   private String poste;
   /** Minute d'entrée dans le jeu (0 signifie qu'il est du onze de départ
    * 
    * @pdOid dec7553a-e4c7-4088-ad4d-b44ab41e852e */
   private Integer minute;
   
   /** @pdRoleInfo migr=no name=Joueur assc=association16 mult=0..1 */
   protected Joueur joueurSortant;
   /** @pdRoleInfo migr=no name=Carton assc=association17 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   protected java.util.Collection<Carton> cartons;
   /** @pdRoleInfo migr=no name=But assc=association18 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   protected java.util.Collection<But> buts;
   /** @pdRoleInfo migr=no name=Joueur assc=joueurFeuilleDeMatch mult=1..1 side=A */
   protected Joueur joueurEntrant;
   /** @pdRoleInfo migr=no name=Equipe assc=equipeFeuilleDeMatch mult=1..1 side=A */
   protected Equipe equipe;
   
   /** @pdOid 1000cfbf-a4ff-44c9-b8e9-18aa14bfa7a2 */
   protected void finalize() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Carton> getCartons() {
      if (cartons == null)
         cartons = new java.util.HashSet<Carton>();
      return cartons;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorCartons() {
      if (cartons == null)
         cartons = new java.util.HashSet<Carton>();
      return cartons.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCartons */
   public void setCartons(java.util.Collection<Carton> newCartons) {
      removeAllCartons();
      for (java.util.Iterator iter = newCartons.iterator(); iter.hasNext();)
         addCartons((Carton)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCarton */
   public void addCartons(Carton newCarton) {
      if (newCarton == null)
         return;
      if (this.cartons == null)
         this.cartons = new java.util.HashSet<Carton>();
      if (!this.cartons.contains(newCarton))
         this.cartons.add(newCarton);
   }
   
   /** @pdGenerated default remove
     * @param oldCarton */
   public void removeCartons(Carton oldCarton) {
      if (oldCarton == null)
         return;
      if (this.cartons != null)
         if (this.cartons.contains(oldCarton))
            this.cartons.remove(oldCarton);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCartons() {
      if (cartons != null)
         cartons.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<But> getButs() {
      if (buts == null)
         buts = new java.util.HashSet<But>();
      return buts;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorButs() {
      if (buts == null)
         buts = new java.util.HashSet<But>();
      return buts.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newButs */
   public void setButs(java.util.Collection<But> newButs) {
      removeAllButs();
      for (java.util.Iterator iter = newButs.iterator(); iter.hasNext();)
         addButs((But)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newBut */
   public void addButs(But newBut) {
      if (newBut == null)
         return;
      if (this.buts == null)
         this.buts = new java.util.HashSet<But>();
      if (!this.buts.contains(newBut))
         this.buts.add(newBut);
   }
   
   /** @pdGenerated default remove
     * @param oldBut */
   public void removeButs(But oldBut) {
      if (oldBut == null)
         return;
      if (this.buts != null)
         if (this.buts.contains(oldBut))
            this.buts.remove(oldBut);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllButs() {
      if (buts != null)
         buts.clear();
   }
   
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid 2fcc7991-4830-4432-9232-380df99f2496 */
   boolean updated = false;
   
   /** @param idFeuilleDeMatch 
    * @param match 
    * @param equipe 
    * @param joueur
    * @pdOid c9601706-5a9f-4b91-94f7-56c9227195b8 */
   public FeuilleDeMatch(int idFeuilleDeMatch, Match match, Equipe equipe, Joueur joueur) {
      // TODO: implement
   }
   
   /** @pdOid fca868a8-17a2-491e-afcc-77d310c65705 */
   public String getPoste() {
      return poste;
   }
   
   /** @param newPoste
    * @pdOid 68e6ccb1-b7a1-4fcd-930e-904a76cb0336 */
   public void setPoste(String newPoste) {
      poste = newPoste;
   }
   
   /** @pdOid 5d7a53bf-cb60-4427-9bb8-8017721903d6 */
   public Integer getMinute() {
      return minute;
   }
   
   /** @param newMinute
    * @pdOid 90da16d6-fd21-48b0-a560-164fc377003d */
   public void setMinute(Integer newMinute) {
      minute = newMinute;
   }
   
   /** @pdOid da2029e5-055f-4f2d-a259-e401809eaa07 */
   public String toString() {
      return this.minute + " " + this.poste;
   }

}