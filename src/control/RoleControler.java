/***********************************************************************
 * Module:  RoleControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class RoleControler
 ***********************************************************************/

package control;

import model.Role;
import java.util.*;

/** @pdOid e3e78e4e-91fc-408f-a323-0ffb135de6e5 */
public class RoleControler {
   /** @param role
    * @pdOid c356aae7-2ea3-47b1-8c31-810f49859157 */
   public static boolean save(Role role) {
      // TODO: implement
      return false;
   }
   
   /** @param role
    * @pdOid 2d8d3a75-03d3-4800-98f4-84a9ddf028ec */
   public static boolean delete(Role role) {
      // TODO: implement
      return false;
   }
   
   /** @param text 
    * @param format
    * @pdOid db999a80-aaba-456a-9483-69b0695006a0 */
   public static boolean check(String text, String format) {
      return GenericControler.check(text, format);
   }
   
   /** @param role
    * @pdOid 9135a22c-e4f5-481a-9bb4-742f8b13c856 */
   public static void viewRole(Role role) {
      // TODO: implement
   }
   
   /** @param role
    * @pdOid 7b9129ad-10c5-48ac-a43e-9e54918d5ef3 */
   public static void editRole(Role role) {
      // TODO: implement
   }

}