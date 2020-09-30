/***********************************************************************
 * Module:  MatchControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class MatchControler
 ***********************************************************************/

package control;

import model.Match;
import model.Equipe;
import model.FeuilleDeMatch;
import java.util.*;

/** @pdOid be2f89e8-2878-48fa-b525-8e084c76f6a0 */
public class MatchControler {
   /** @param match
    * @exception Exception
    * @pdOid 44e78cb7-209f-4b9e-9a25-6fea471fd9dc */
   public static boolean save(Match match) throws Exception  {
      // TODO: implement
      return false;
   }
   
   /** @param match
    * @exception Exception
    * @pdOid 186d789d-0611-4a07-a7f8-cbfb4bb57097 */
   public static boolean delete(Match match) throws Exception {
      // TODO: implement
      return false;
   }
   
   /** @param text 
    * @param format
    * @exception Exception
    * @pdOid 0ff1d832-2f25-4a43-8c70-f87b7e9ccb7f */
   public static boolean check(String text, String format) throws Exception {
      return GenericControler.check(text, format);
   }
   
   /** @param match
    * @pdOid 5bbcabe2-2555-458c-920c-ae7d6c3bffd6 */
   public static void viewMatch(Match match) {
      // TODO: implement
   }
   
   /** @param match
    * @pdOid 1acd73af-577b-40a1-a038-44193987f490 */
   public static void editMatch(Match match) {
      // TODO: implement
   }
   
   /** @param equipe
    * @pdOid 3141289e-2a6e-4824-83d8-c55495d28625 */
   public static void viewEquipe(Equipe equipe) {
      EquipeControler.viewEquipe(equipe);
   }
   
   /** @param feuilleDeMatch
    * @pdOid 11f66941-e812-41f4-b730-3bc472f65f6b */
   public void viewFeuilleDeMatch(FeuilleDeMatch feuilleDeMatch) {
      FeuilleDeMatchControler.viewFeuilleDeMatch(feuilleDeMatch);
   }

}