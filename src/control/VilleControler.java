/***********************************************************************
 * Module:  VilleControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class VilleControler
 ***********************************************************************/

package control;

import model.Ville;
import model.Pays;
import java.util.*;

/** @pdOid 2f33f978-f0ff-4528-b3d5-c76b016e2626 */
public class VilleControler {
   /** @param ville
    * @pdOid dcfd7f2c-43a2-4be9-b167-02346eb5d8d0 */
   public static boolean save(Ville ville) {
      // TODO: implement
      return false;
   }
   
   /** @param ville
    * @pdOid ce192a46-6990-4813-abee-3aab5453a14e */
   public static boolean delete(Ville ville) {
      // TODO: implement
      return false;
   }
   
   /** @param text 
    * @param format
    * @pdOid 43da15b0-084c-459c-a993-035263fe5da1 */
   public static boolean check(String text, String format) {
      return GenericControler.check(text, format);
   }
   
   /** @param ville
    * @pdOid 2ac8951f-fa4e-48db-91c8-f43ab27cf300 */
   public static void viewVille(Ville ville) {
      // TODO: implement
   }
   
   /** @param ville
    * @pdOid 50e6652a-b37b-45b6-b09a-b88757ad385e */
   public static void editVille(Ville ville) {
      // TODO: implement
   }
   
   /** @pdOid 38314158-cd98-4a25-bbbd-497f1435426b */
   public static void editNewVille() {
      // TODO: implement
   }
   
   /** @param pays
    * @pdOid 05d69275-4dcd-4ca6-90fc-3bca32ba7d94 */
   public static void viewPays(Pays pays) {
      PaysControler.viewPays(pays);
   }

}