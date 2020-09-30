/***********************************************************************
 * Module:  SaisonControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class SaisonControler
 ***********************************************************************/

package control;

import model.Saison;
import model.Journee;
import java.util.*;

/** @pdOid a38acaae-bc76-4eef-9146-fc30145bc5c8 */
public class SaisonControler {
   /** @param saison
    * @pdOid c6cf27ce-bedd-40d9-9980-d70ca1c9dd33 */
   public static boolean save(Saison saison) {
      // TODO: implement
      return false;
   }
   
   /** @param saison
    * @pdOid 21528517-e50f-452e-b0ee-6d1fbd95cb6b */
   public static boolean delete(Saison saison) {
      // TODO: implement
      return false;
   }
   
   /** @param text 
    * @param format
    * @pdOid 3edc6b34-bf54-4851-bea4-89560d48bc21 */
   public static boolean check(String text, String format) {
      return GenericControler.check(text, format);
   }
   
   /** @param saison
    * @pdOid f9e924eb-2fdc-4660-8db4-63576d270d00 */
   public static void viewSaison(Saison saison) {
      // TODO: implement
   }
   
   /** @pdOid 8804d92e-ddc4-4b92-9e0a-6b5cf2ed6074 */
   public static void editNewSaison() {
      // TODO: implement
   }
   
   /** @param saison
    * @pdOid a8821ad9-52af-4230-9fa6-5f9a577c6f01 */
   public static void generateCalendar(Saison saison) {
      model.CalendarGenerator.generateCalendar(saison);
   }
   
   /** @param journee
    * @pdOid 4f37722c-7117-492b-8990-acaaa2621b2a */
   public static void viewJournee(Journee journee) {
      JourneeControler.viewJournee(journee);
   }

}