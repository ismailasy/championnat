/***********************************************************************
 * Module:  JourneeControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class JourneeControler
 ***********************************************************************/

package control;

import model.Journee;
import model.Match;
import java.util.*;

/** @pdOid 85d53c3e-a0ad-466a-899b-270c207dc9fc */
public class JourneeControler {
   /** @param journee
    * @pdOid 65e2cec8-6a37-48ca-89ab-1c5d001e3ce3 */
   public static boolean save(Journee journee) {
      // TODO: implement
      return false;
   }
   
   /** @param journee
    * @pdOid ac74a02b-ad33-4462-8ff3-b9568f040dfc */
   public static boolean delete(Journee journee) {
      // TODO: implement
      return false;
   }
   
   /** @param text 
    * @param format
    * @pdOid 5614e511-5fc3-4647-8b71-1b1176519b0a */
   public static boolean check(String text, String format) {
      return GenericControler.check(text, format);
   }
   
   /** @param journee
    * @pdOid 568739b6-032a-467c-b595-acdd3ab606b9 */
   public static void viewJournee(Journee journee) {
      // TODO: implement
   }
   
   /** @param match
    * @pdOid 38c4567b-fcb9-4ef9-b36e-1a3518163e9b */
   public static void viewMatch(Match match) {
      MatchControler.viewMatch(match);
   }

}