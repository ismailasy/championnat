/***********************************************************************
 * Module:  UserControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class UserControler
 ***********************************************************************/

package control;

import model.User;
import model.Role;
import java.util.*;

/** @pdOid a2363387-99e5-4df2-9a11-eca3d0e0758f */
public class UserControler {
   /** @param user
    * @pdOid 92e7eebb-3514-4fb4-90a0-adad3099dfe3 */
   public static boolean save(User user) {
      // TODO: implement
      return false;
   }
   
   /** @param user
    * @pdOid 7c713b55-971e-4781-9c0e-3c9e9bf6bcf3 */
   public static boolean delete(User user) {
      // TODO: implement
      return false;
   }
   
   /** @param text 
    * @param format
    * @pdOid eef2d1aa-5481-4c5d-b4a5-dfe9a3c89083 */
   public static boolean check(String text, String format) {
      return GenericControler.check(text, format);
   }
   
   /** @param user
    * @pdOid 5cc90458-dfa4-403e-885a-f19c62f71f4c */
   public static void viewUser(User user) {
      // TODO: implement
   }
   
   /** @param user
    * @pdOid 1779ad0e-6520-4fda-b755-a638a050c94c */
   public static void editUser(User user) {
      // TODO: implement
   }
   
   /** @pdOid a279d96f-c44a-4fb6-b07e-bc32ac01b8a2 */
   public static void editNewUser() {
      // TODO: implement
   }
   
   /** @param role
    * @pdOid 37746930-2a05-4758-8b38-95474f24f100 */
   public static void viewRole(Role role) {
      RoleControler.viewRole(role);
   }

}