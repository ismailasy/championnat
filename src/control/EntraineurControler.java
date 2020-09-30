/***********************************************************************
 * Module:  EntraineurControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class EntraineurControler
 ***********************************************************************/

package control;

import model.Entraineur;
import model.Contrat;
import java.util.*;

/** @pdOid 8da08652-daee-46ab-8732-94f765d66ee8 */
public class EntraineurControler {
   /** @param entraineur
    * @pdOid 29a67ac8-4446-4345-8454-cca01d7b197f */
   public static boolean save(Entraineur entraineur) {
      // TODO: implement
      return false;
   }
   
   /** @param entraineur
    * @pdOid 8b83c5ec-e17a-4b8b-bc82-9cafae2dafdd */
   public static boolean delete(Entraineur entraineur) {
      // TODO: implement
      return false;
   }
   
   /** @param text 
    * @param format
    * @pdOid ab2148b8-a2c0-45a6-8f27-6f1736d2282b */
   public static boolean check(String text, String format) {
      return GenericControler.check(text, format);
   }
   
   /** @param entraineur
    * @pdOid 87919ec9-29be-4885-a5e6-101257638041 */
   public static void viewEntraineur(Entraineur entraineur) {
      // TODO: implement
   }
   
   /** @param entraineur
    * @pdOid 0eb217c3-e555-40d6-b005-c0b256976535 */
   public static void editEntraineur(Entraineur entraineur) {
      // TODO: implement
   }
   
   /** @pdOid a0ada108-fe68-42fc-811b-b4429c8fa527 */
   public static void editNewEntraineur() {
      // TODO: implement
   }
   
   /** @param contrat
    * @pdOid 025e758d-ebd5-47ee-b6b0-3e5593a31da9 */
   public static void viewContrat(Contrat contrat) {
      ContratControler.viewContrat(contrat);
   }

}