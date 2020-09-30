/***********************************************************************
 * Module:  Match.java
 * Author:  Lenovo
 * Purpose: Defines the Class Match
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 52c5b0f8-8e2a-47fa-a835-62d4ba332177 */
public class Match {
   /** @pdOid 254f99b3-e249-4b3d-b4a8-cd8c58365500 */
   private Date heureDebut;
   /** @pdOid f03768d8-0fd9-4f55-9fc8-da35584e3ac9 */
   private short duree;
   /** @pdOid 4f242a91-ebf7-46ad-a809-96ac53afc45c */
   private short nbButsDom;
   /** @pdOid 9dd1ee1b-4c1b-4ac1-aece-ae6ecce80c5a */
   private short nbButsExt;
   
   /** @pdRoleInfo migr=no name=FeuilleDeMatch assc=matchFeuilleDeMatch coll=java.util.List impl=java.util.ArrayList mult=1..* */
   protected java.util.List<FeuilleDeMatch> feuilleDuMatch;
   /** @pdRoleInfo migr=no name=Journee assc=jouneeMatchs mult=1..1 side=A */
   protected Journee journee;
   /** @pdRoleInfo migr=no name=Equipe assc=matchEquipeDomicile mult=1..1 side=A */
   protected Equipe equipe_dom;
   /** @pdRoleInfo migr=no name=Equipe assc=matchEquipeExterieur mult=1..1 side=A */
   protected Equipe equipe_ext;
   
   /** @pdOid 037fa6ae-ad13-4109-81ed-d05a47049dd5 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @param match
    * @exception Exception
    * @pdOid 7be568e7-d4af-4f0b-bb16-113291be944f */
   protected boolean save(Match match) throws Exception  {
      // TODO: implement
      return false;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<FeuilleDeMatch> getFeuilleDuMatch() {
      if (feuilleDuMatch == null)
         feuilleDuMatch = new java.util.ArrayList<FeuilleDeMatch>();
      return feuilleDuMatch;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorFeuilleDuMatch() {
      if (feuilleDuMatch == null)
         feuilleDuMatch = new java.util.ArrayList<FeuilleDeMatch>();
      return feuilleDuMatch.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newFeuilleDuMatch */
   public void setFeuilleDuMatch(java.util.List<FeuilleDeMatch> newFeuilleDuMatch) {
      removeAllFeuilleDuMatch();
      for (java.util.Iterator iter = newFeuilleDuMatch.iterator(); iter.hasNext();)
         addFeuilleDuMatch((FeuilleDeMatch)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newFeuilleDeMatch */
   public void addFeuilleDuMatch(FeuilleDeMatch newFeuilleDeMatch) {
      if (newFeuilleDeMatch == null)
         return;
      if (this.feuilleDuMatch == null)
         this.feuilleDuMatch = new java.util.ArrayList<FeuilleDeMatch>();
      if (!this.feuilleDuMatch.contains(newFeuilleDeMatch))
         this.feuilleDuMatch.add(newFeuilleDeMatch);
   }
   
   /** @pdGenerated default remove
     * @param oldFeuilleDeMatch */
   public void removeFeuilleDuMatch(FeuilleDeMatch oldFeuilleDeMatch) {
      if (oldFeuilleDeMatch == null)
         return;
      if (this.feuilleDuMatch != null)
         if (this.feuilleDuMatch.contains(oldFeuilleDeMatch))
            this.feuilleDuMatch.remove(oldFeuilleDeMatch);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllFeuilleDuMatch() {
      if (feuilleDuMatch != null)
         feuilleDuMatch.clear();
   }
   /** @pdGenerated default parent getter */
   public Journee getJournee() {
      return journee;
   }
   
   /** @pdGenerated default parent setter
     * @param newJournee */
   public void setJournee(Journee newJournee) {
      if (this.journee == null || !this.journee.equals(newJournee))
      {
         if (this.journee != null)
         {
            Journee oldJournee = this.journee;
            this.journee = null;
            oldJournee.removeMatch(this);
         }
         if (newJournee != null)
         {
            this.journee = newJournee;
            this.journee.addMatch(this);
         }
      }
   }
   
   /** Identifiant du match
    * 
    * @pdOid ab54da96-cabe-4b8b-86dd-7f464ee40e35 */
   int idMatch;
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid 1abadce2-1fdc-4b3b-80dd-fcd7879f6b94 */
   boolean updated = false;
   
   /** @pdOid 4dd07bf8-05b4-4b59-8848-585a561ce76c */
   public java.util.List butJoueurMatch;
   /** @pdOid 1a886e51-e898-4e49-a19f-833e8bc33579 */
   public java.util.List cartonRougeJoueurMatch;
   
   /** @param journee
    * @pdOid f7ed0ce0-2958-4353-a392-de1f14338612 */
   public Match(Journee journee) {
      this.journee = journee;
   }
   
   /** @pdOid c667ba02-fde6-40f3-9e56-5403ccd2f82f */
   public int getIdMatch() {
      return idMatch;
   }
   
   /** @pdOid 31165c72-2738-471d-948c-a2bbcd800dd7 */
   public Date getHeureDebut() {
      return heureDebut;
   }
   
   /** @param newHeureDebut
    * @pdOid b7570f83-862a-4967-bf2c-ffe80d9b80c7 */
   public void setHeureDebut(Date newHeureDebut) {
      heureDebut = newHeureDebut;
   }
   
   /** @pdOid 9e17ccdc-f798-437f-b632-6f5af2565231 */
   public short getDuree() {
      return duree;
   }
   
   /** @param newDuree
    * @pdOid 9e63c9c8-6063-40d7-a283-6310cb4158b7 */
   public void setDuree(short newDuree) {
      duree = newDuree;
   }
   
   /** @pdOid d0553fed-76c6-485f-99ea-f39d8548ce52 */
   public short getNbButsDom() {
      return nbButsDom;
   }
   
   /** @pdOid 9992ae29-66fa-40ff-96c8-4fb331a9f297 */
   public short getNbButsExt() {
      return nbButsExt;
   }
   
   /** @pdOid f2e2801d-2e41-4d36-84ce-ca52b7b2e0cc */
   public String toString() {
      return this.heureDebut + " " + this.duree;
   }
   
   /** @exception Exception
    * @pdOid 05839f97-74e5-4c4c-94a5-9423f316b017 */
   public static Match[] getMatchs() throws Exception {
      // TODO: implement
      return null;
   }
   
   /** @param journee
    * @exception Exception
    * @pdOid 1a95ef11-c03e-4e97-83e1-f568a93ceb80 */
   public static Match[] getMatchs(Journee journee) throws Exception {
      // TODO: implement
      return null;
   }
   
   /** @param saison
    * @exception Exception
    * @pdOid 82d24d24-8b9f-45ed-a9d5-63915177e009 */
   public static Match[] getMatchs(Saison saison) throws Exception {
      // TODO: implement
      return null;
   }
   
   /** @param idMatch
    * @pdOid b58276f9-b38c-464c-98ae-90805966c2ac */
   public static Match getMatch(int idMatch) {
      // TODO: implement
      return null;
   }
   
   /** @param numero 
    * @param annee 
    * @param idEquipeDom
    * @pdOid 18ef552e-9371-4e62-8f35-4cb1ed187f72 */
   public static Match getMatch(short numero, short annee, int idEquipeDom) {
      // TODO: implement
      return null;
   }

}