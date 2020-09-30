/***********************************************************************
 * Module:  User.java
 * Author:  Lenovo
 * Purpose: Defines the Class User
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 9a39008d-a561-413f-96a3-43894025fbba */
public class User {
   /** @pdOid 63d7e0b9-c081-494d-9ca6-d6ad77b7d393 */
   private String id;
   /** @pdOid c9049c78-95e0-48d4-abb6-d202a2e92076 */
   private String login;
   /** @pdOid 8bf35eeb-985c-412b-870b-000ceba9ccfd */
   private String password;
   
   /** @pdRoleInfo migr=no name=Role assc=association15 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   protected java.util.Collection<Role> role;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Role> getRole() {
      if (role == null)
         role = new java.util.HashSet<Role>();
      return role;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRole() {
      if (role == null)
         role = new java.util.HashSet<Role>();
      return role.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRole */
   public void setRole(java.util.Collection<Role> newRole) {
      removeAllRole();
      for (java.util.Iterator iter = newRole.iterator(); iter.hasNext();)
         addRole((Role)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRole */
   public void addRole(Role newRole) {
      if (newRole == null)
         return;
      if (this.role == null)
         this.role = new java.util.HashSet<Role>();
      if (!this.role.contains(newRole))
         this.role.add(newRole);
   }
   
   /** @pdGenerated default remove
     * @param oldRole */
   public void removeRole(Role oldRole) {
      if (oldRole == null)
         return;
      if (this.role != null)
         if (this.role.contains(oldRole))
            this.role.remove(oldRole);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllRole() {
      if (role != null)
         role.clear();
   }
   
   /** @pdOid c8647d25-c758-44e2-bc1b-d6d9a63839b1 */
   public String getId() {
      return id;
   }
   
   /** @pdOid 615f005a-8bdb-4a54-80b2-d5ca952aacb4 */
   public String getLogin() {
      return login;
   }
   
   /** @param newLogin
    * @pdOid 95db5ce9-ba2b-489b-9472-8d0eb144c304 */
   public void setLogin(String newLogin) {
      login = newLogin;
   }
   
   /** @pdOid 752e89a1-c932-4d50-9561-970dab9493b3 */
   public String getPassword() {
      return password;
   }
   
   /** @param newPassword
    * @pdOid 3e9470ff-b5b5-4d84-a291-0bb8534a6549 */
   public void setPassword(String newPassword) {
      password = newPassword;
   }

}