/***********************************************************************
 * Module:  But.java
 * Author:  Lenovo
 * Purpose: Defines the Class But
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid b833d07c-2a94-4830-8d75-e4e70990d708 */
public class But {
   /** @pdOid 3a2e920d-0bad-4f3c-af21-d3b6bd128ea4 */
   private short minute;
   /** @pdOid bfd7783d-394c-4ad3-8efe-73399e4e8b92 */
   private boolean autogoal;
   
   /** @pdOid d1f9f03b-c43b-42b9-b0fc-2a33e8435a7b */
   protected void finalize() {
      // TODO: implement
   }
   
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid 79034dc5-9104-40fb-a349-a35c04a6904c */
   boolean updated = false;
   
   /** @pdOid 7f862f19-d5d8-4b87-9145-03af66812a98 */
   public But() {
      // TODO: implement
   }
   
   /** @pdOid 69754945-39e6-4448-a843-1864a57437c3 */
   public short getMinute() {
      return minute;
   }
   
   /** @param newMinute
    * @pdOid 1b482b1e-c704-4d4b-9377-5621e4f776e3 */
   public void setMinute(short newMinute) {
      minute = newMinute;
   }
   
   /** @pdOid a5311626-68eb-4d9e-b147-54a62a345621 */
   public boolean getAutogoal() {
      return autogoal;
   }
   
   /** @param newAutogoal
    * @pdOid 924b608c-45c3-4066-af32-f8b108fd6e9f */
   public void setAutogoal(boolean newAutogoal) {
      autogoal = newAutogoal;
   }
   
   /** @pdOid 5c505798-71e5-47bf-b4c4-f5ea0edfade7 */
   public String toString() {
      return this.minute + ((this.autogoal)? " (Autogoal)" : "");
   }

}