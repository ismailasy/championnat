/***********************************************************************
 * Module:  Saison.java
 * Author:  Lenovo
 * Purpose: Defines the Class Saison
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid c7d2a1d6-179d-4921-96ec-074ad96fd23f */
public class Saison {
   /** @pdOid d7e5a46c-e5a8-429a-8cac-b9384ffdb832 */
   private short annee;
   /** @pdOid 68ef8767-d558-4568-b622-0a51a7e0da5f */
   private Date dateDebut;
   /** @pdOid d6f7da43-4214-458e-bd28-40284434041a */
   private Date dateFin;
   
   /** @pdRoleInfo migr=no name=Journee assc=saisonJournees coll=java.util.List impl=java.util.ArrayList mult=1..* type=Aggregation */
   protected java.util.List<Journee> journees;
   
   /** @pdOid a3c3297a-b84b-4b22-8a05-f7ebcc57786c */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @param saison
    * @pdOid 34553e29-f8d4-464b-a2f5-81e1bcb6c447 */
   protected static boolean delete(Saison saison) {
      // TODO: implement
      return false;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Journee> getJournees() {
      if (journees == null)
         journees = new java.util.ArrayList<Journee>();
      return journees;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorJournees() {
      if (journees == null)
         journees = new java.util.ArrayList<Journee>();
      return journees.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newJournees */
   public void setJournees(java.util.List<Journee> newJournees) {
      removeAllJournees();
      for (java.util.Iterator iter = newJournees.iterator(); iter.hasNext();)
         addJournees((Journee)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newJournee */
   public void addJournees(Journee newJournee) {
      if (newJournee == null)
         return;
      if (this.journees == null)
         this.journees = new java.util.ArrayList<Journee>();
      if (!this.journees.contains(newJournee))
      {
         this.journees.add(newJournee);
         newJournee.setSaison(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldJournee */
   public void removeJournees(Journee oldJournee) {
      if (oldJournee == null)
         return;
      if (this.journees != null)
         if (this.journees.contains(oldJournee))
         {
            this.journees.remove(oldJournee);
            oldJournee.setSaison((Saison)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllJournees() {
      if (journees != null)
      {
         Journee oldJournee;
         for (java.util.Iterator iter = getIteratorJournees(); iter.hasNext();)
         {
            oldJournee = (Journee)iter.next();
            iter.remove();
            oldJournee.setSaison((Saison)null);
         }
      }
   }
   
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid 0b00f206-11da-488f-b12c-e11c4275df53 */
   boolean updated = false;
   
   /** @pdOid ec50c986-7c23-4f1a-9c15-314a50420921 */
   public Saison() {
      // TODO: implement
   }
   
   /** @pdOid e8516e55-9ae5-4d5b-a46f-eb77d19c76e4 */
   public short getAnnee() {
      return annee;
   }
   
   /** @param newAnnee
    * @pdOid f85637ec-eedd-4847-bacb-cf80d460ba19 */
   public void setAnnee(short newAnnee) {
      annee = newAnnee;
   }
   
   /** @pdOid d1c380eb-15f4-448a-859d-963c81aa257a */
   public static Saison[] getSaisons() {
      // TODO: implement
      return null;
   }
   
   public static Saison getLastSaison(){
	   
	   return null;
   }
   
   /** @param annee
    * @pdOid 11655d12-9a4e-401b-ae7b-f440b0aa9a80 */
   public static Saison getSaison(short annee) {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 0f48c6b5-2f86-4beb-ae57-f7511983d8a1 */
   public Date getDateDebut() {
      return dateDebut;
   }
   
   /** @param newDateDebut
    * @pdOid eb9107eb-89c7-4095-96e9-3d4bee66e7fb */
   public void setDateDebut(Date newDateDebut) {
      dateDebut = newDateDebut;
   }
   
   /** @pdOid b5e660b2-4ad1-4c38-a03e-20012ae44746 */
   public Date getDateFin() {
      return dateFin;
   }
   
   /** @param newDateFin
    * @pdOid 7d65c3b8-585a-4281-b017-85222ef14eab */
   public void setDateFin(Date newDateFin) {
      dateFin = newDateFin;
   }
   
   /** @pdOid ea80ac55-6250-4428-892d-e7c7aedfb49b */
   public String toString() {
      return this.annee + " (" + this.dateDebut + " - " + this.dateFin + ")";
   }

}