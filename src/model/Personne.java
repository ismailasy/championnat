/***********************************************************************
 * Module:  Personne.java
 * Author:  Lenovo
 * Purpose: Defines the Class Personne
 ***********************************************************************/

package model;

import java.util.*;

/** Modou Gueye
 * 1.0
 * 
 * @pdOid 645f31fc-51d8-4dc4-9032-d03da719c96d */
public class Personne {
   /** @pdOid 236e92a2-9364-4f1f-aac3-f710c7cafec0 */
   protected java.lang.String licence;
   /** @pdOid 6e1d3cfd-2466-4658-8a7d-f45641a220a0 */
   protected java.util.Date dateAcquisition;
   /** @pdOid 238f1548-cc6e-4780-abf2-87e78717b365 */
   protected java.lang.String photo;
   /** @pdOid fb882873-8dbc-4ff0-b6c3-f966ff82b6d1 */
   protected java.lang.String nom;
   /** @pdOid 1b1a41d6-8fdd-41c8-ac32-c4f48ca09557 */
   protected java.lang.String prenom;
   /** @pdOid effd014e-0db4-4b1e-92b3-6b441c58d556 */
   protected java.util.Date dateNaissance;
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid b572760d-ee54-45fd-807f-d3f59437eba3 */
   protected boolean updated = false;
   
   /** @pdRoleInfo migr=no name=Pays assc=avoirNationalites coll=java.util.List impl=java.util.ArrayList mult=0..* */
   protected java.util.List<Pays> pays;
   /** @pdRoleInfo migr=no name=Pays assc=paysDeNaissance mult=1..1 side=A */
   protected Pays lieuNaiss;
   
   /** @pdOid e79f7f5c-9742-49ef-8545-7f1006866448 */
   protected void finalize() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Pays> getPays() {
      if (pays == null)
         pays = new java.util.ArrayList<Pays>();
      return pays;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPays() {
      if (pays == null)
         pays = new java.util.ArrayList<Pays>();
      return pays.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPays */
   public void setPays(java.util.List<Pays> newPays) {
      removeAllPays();
      for (java.util.Iterator iter = newPays.iterator(); iter.hasNext();)
         addPays((Pays)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPays */
   public void addPays(Pays newPays) {
      if (newPays == null)
         return;
      if (this.pays == null)
         this.pays = new java.util.ArrayList<Pays>();
      if (!this.pays.contains(newPays))
         this.pays.add(newPays);
   }
   
   /** @pdGenerated default remove
     * @param oldPays */
   public void removePays(Pays oldPays) {
      if (oldPays == null)
         return;
      if (this.pays != null)
         if (this.pays.contains(oldPays))
            this.pays.remove(oldPays);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPays() {
      if (pays != null)
         pays.clear();
   }
   
   /** @pdOid d654ee1e-5e8f-4b99-b330-79725cad79bb */
   int idPersonne;
   
   /** @pdOid 2c2c79c5-a421-483a-9dd2-35a7a8c2e8de */
   public Personne() {
      // TODO: implement
   }
   
   /** @pdOid 1d06f6f7-0a4f-4f3e-8a62-b5a578591a99 */
   public int getIdPersonne() {
      return idPersonne;
   }
   
   /** @pdOid 34c2cae9-b9e6-45b0-8384-2399f74a039c */
   public java.lang.String getLicence() {
      return licence;
   }
   
   /** @param newLicence
    * @pdOid fcf81d18-a818-4d15-9720-6a1be8d5dc44 */
   public void setLicence(java.lang.String newLicence) {
      licence = newLicence;
   }
   
   /** @pdOid d925a7bd-b5ff-47fb-b09b-34dc5c4d728b */
   public java.util.Date getDateAcquisition() {
	   if(dateAcquisition == null)
		   return new Date();
      return dateAcquisition;
   }
   
   /** @param newDateAcquisition
    * @pdOid 03dc5057-059c-415d-ac8e-7f0aaf319d3b */
   public void setDateAcquisition(java.util.Date newDateAcquisition) {
      dateAcquisition = newDateAcquisition;
   }
   
   /** @pdOid 7cbcb12d-688d-48f0-8150-287815165cf7 */
   public java.lang.String getPhoto() {
      return photo;
   }
   
   /** @param newPhoto
    * @pdOid f9fbfa04-ded7-4c88-bd42-038947a67d43 */
   public void setPhoto(java.lang.String newPhoto) {
      photo = newPhoto;
   }
   
   /** @pdOid 25f1a8ec-641f-4a01-90ee-11e7d0cc1a3a */
   public java.lang.String getNom() {
      return nom;
   }
   
   /** @param newNom
    * @pdOid 4ab55867-13c8-47c3-b6dd-b688c668dd23 */
   public void setNom(java.lang.String newNom) {
      nom = newNom;
   }
   
   /** @pdOid 4743b5a7-b0aa-46ed-a124-fecab3121a68 */
   public java.lang.String getPrenom() {
      return prenom;
   }
   
   /** @param newPrenom
    * @pdOid 7c96c125-782f-454f-8883-9ceef3b8b5ff */
   public void setPrenom(java.lang.String newPrenom) {
      prenom = newPrenom;
   }
   
   /** @pdOid 0de7901e-7738-4310-abfb-e5bb35b64b26 */
   public java.util.Date getDateNaissance() {
	   if(dateNaissance == null)
		   return new Date();
      return dateNaissance;
   }
   
   /** @param newDateNaissance
    * @pdOid dbd48b02-1524-42e2-af56-5d8968b35ec5 */
   public void setDateNaissance(java.util.Date newDateNaissance) {
      dateNaissance = newDateNaissance;
   }
   
   /** @pdOid cef363a9-1fb7-4761-a825-2a7ad7b574af */
   public String toString() {
      return this.nom + " (" + this.licence + ")";
   }
   
   public Pays getLieuNaiss(){
	   return this.lieuNaiss;
   }
   
   public void setLieuNaiss(Pays lieuNaiss){
	   this.lieuNaiss = lieuNaiss;
   }
   
}