/***********************************************************************
 * Module:  Carton.java
 * Author:  Lenovo
 * Purpose: Defines the Class Carton
 ***********************************************************************/

package model;

import java.util.*;

/** @pdOid 0be3dfe5-99b4-404e-834c-12c2a670a0ef */
public class Carton {
   /** @pdOid bfbeacae-0b1b-4235-bcbd-bbc55bfa3035 */
   protected String minute;
   
   /** @pdOid d277d5e2-6435-4a32-83e7-a1a7ff5b2538 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** Objet modifié et pas encore enregistré ou pas
    * 
    * @pdOid d79951bd-4481-4da7-b7ea-611a1acda407 */
   boolean updated = false;
   
   /** @pdOid ebb8c5f7-967d-4f83-9e3a-4741941c1c48 */
   public Carton() {
      // TODO: implement
   }
   
   /** @pdOid 5cd2e9be-219e-40e0-a5e4-bf416c92131d */
   public String getMinute() {
      return minute;
   }
   
   /** @param newMinute
    * @pdOid c142f9cb-fbe0-4c3c-9933-9e51c2b89f60 */
   public void setMinute(String newMinute) {
      minute = newMinute;
   }
   
   /** @pdOid f4511a11-d8f6-4f9c-b15e-1ea521759953 */
   public String toString() {
      return this.minute;
   }

}