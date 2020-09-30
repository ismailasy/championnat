/***********************************************************************
 * Module:  IEditComponent.java
 * Author:  Lenovo
 * Purpose: Defines the Interface IEditComponent
 ***********************************************************************/

package view;

import java.util.*;

/** @pdOid f862d41e-3c05-4921-8198-e16f85d2f57a */
public interface IEditComponent {
   /** @pdOid 6d523095-d614-4662-926d-e959e1f18e1a */
   boolean isModified();
   /** @pdOid ffd5fe09-59e0-4fa8-9135-34b7a99dbb9a */
   void save();
   /** @pdOid 861b41ea-cf05-4db8-86d2-107d5e2c2f09 */
   void close();

}