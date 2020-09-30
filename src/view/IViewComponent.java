/***********************************************************************
 * Module:  IViewComponent.java
 * Author:  Lenovo
 * Purpose: Defines the Interface IViewComponent
 ***********************************************************************/

package view;

import java.util.*;

/** @pdOid 83288548-1851-4d10-b498-407ef4d3e023 */
public interface IViewComponent {
   /** @pdOid 3b1ed7ab-6b0a-4455-a636-faa8746e39cb */
   boolean isPrintable();
   /** @pdOid f3541b18-039f-442d-98cd-ca52b1396406 */
   boolean isEditable();
   /** @pdOid 68825f86-eba4-4721-a4ee-24a67c4c7cd1 */
   void printView();
   /** @pdOid 55cdd370-76f1-468e-8875-55a8cb90663e */
   void editView();
   /** @pdOid d20d1573-5b81-43b8-b563-ee5e0a11ec17 */
   void close();

}