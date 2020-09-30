/***********************************************************************
 * Module:  Role.java
 * Author:  Lenovo
 * Purpose: Defines the Class Role
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 06537fba-fafc-41a3-bf8d-a3da3b1d5575 */
public class Role {
   /** @pdOid 491c028c-058c-44f4-8c43-ca3f1510e391 */
   private String nom;
   /** @pdOid 94a86b3f-956a-4521-9164-587d263c34c0 */
   private boolean canSeeJournee;
   /** @pdOid bfb80238-88a9-42dc-839e-317fa6cadccb */
   private boolean canEditJournee;
   /** @pdOid 8f51479a-445d-4c4f-9d53-2547d47ce623 */
   private boolean canEditMatch;
   /** @pdOid 6563f447-6477-4f41-8ca7-8a56a12b06d4 */
   private boolean canEditEquipe;
   /** @pdOid 31680bd0-73ae-450a-ae3e-39ddd2b6ffff */
   private boolean canEditJoueur;
   /** @pdOid 1a3a40f6-263c-41b5-9159-7a9fbdec0ce0 */
   private boolean canEditEntrainer;
   
   /** @pdOid 701ce30e-df8a-4004-99c0-9a2a93e903df */
   public String getNom() {
      return nom;
   }
   
   /** @param newNom
    * @pdOid fde0dea5-b7cc-4d1a-8566-a7f122b0639e */
   public void setNom(String newNom) {
      nom = newNom;
   }
   
   /** @pdOid 1c8d77fc-304e-4730-b22e-fd87c0567507 */
   public boolean getCanSeeJournee() {
      return canSeeJournee;
   }
   
   /** @pdOid 0c0d9e6d-5123-4e57-8fda-0fa52b2e5d00 */
   public boolean getCanEditJournee() {
      return canEditJournee;
   }
   
   /** @pdOid 79556121-e9d6-408e-8361-8bdce84c8f28 */
   public boolean getCanEditMatch() {
      return canEditMatch;
   }
   
   /** @pdOid e0e2dc7c-7bec-4a3c-af68-17bb6d3eaf80 */
   public boolean getCanEditEquipe() {
      return canEditEquipe;
   }
   
   /** @pdOid 0a52a5f7-7159-4724-9d8e-ceb4de664da0 */
   public boolean getCanEditJoueur() {
      return canEditJoueur;
   }
   
   /** @pdOid cb7258e9-e803-4cfa-a18b-f8483cc70df5 */
   public boolean getCanEditEntrainer() {
      return canEditEntrainer;
   }

}