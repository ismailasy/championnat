/***********************************************************************
 * Module:  Maillot.java
 * Author:  Lenovo
 * Purpose: Defines the Class Maillot
 ***********************************************************************/

package model;

import java.util.*;

/** Maillot d'un joueur.
 * 
 * @pdOid 53f8bf78-078c-4b26-920e-414577fd3767 */
public class Maillot {
   /** Pour un entraineur, on mettra la valeur 0
    * 
    * @pdOid 4a00f873-289a-490d-bcf9-44efc757fe2a */
   private short numero;
   
   public Saison saison;
   
   /** @pdOid 4248e506-54cb-4fe1-b243-5f0ed1481e5d */
   public short getNumero() {
      return numero;
   }
   
   /** @param newNumero
    * @pdOid 4a2b6374-3169-4236-b80c-cba2a76d2ac1 */
   public void setNumero(short newNumero) {
      numero = newNumero;
   }

}