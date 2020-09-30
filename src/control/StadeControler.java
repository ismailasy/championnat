/***********************************************************************
 * Module:  StadeControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class StadeControler
 ***********************************************************************/

package control;

import model.Stade;
import model.Ville;
import java.util.*;

/** @pdOid 9ad8e339-0e73-492c-b712-49a380ab26a0 */
public class StadeControler {
   /** @param stade
    * @pdOid 866e3acf-2cbb-414c-9161-a71429546baa */
   public static boolean save(Stade stade) {
      // TODO: implement
      return false;
   }
   
   /** @param stade
    * @pdOid 69410395-26d3-41e4-973a-c7477fcae81c */
   public static boolean delete(Stade stade) {
      // TODO: implement
      return false;
   }
   
   /** @param text 
    * @param format
    * @pdOid 0609809f-baae-4247-8123-ffcaf307ea93 */
   public static boolean check(String text, String format) {
      return GenericControler.check(text, format);
   }
   
   /** @param stade
    * @pdOid e1be300d-320b-4957-be10-ee675834e916 */
   public static void viewStade(Stade stade) {
      // TODO: implement
   }
   
   /** @param stade
    * @pdOid e8c8f063-587a-4b5f-b192-c41c8845fc46 */
   public static void editStade(Stade stade) {
      // TODO: implement
   }
   
   /** @pdOid 922ce838-a823-43b6-bbf4-4a767b706a6e */
   public static void editNewStade() {
      // TODO: implement
   }
   
   /** @param ville
    * @pdOid 20c4f33c-74e2-4410-a396-b1f88e5a2cd5 */
   public static void viewVille(Ville ville) {
      VilleControler.viewVille(ville);
   }

}