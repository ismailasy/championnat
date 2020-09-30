/***********************************************************************
 * Module:  EquipeControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class EquipeControler
 ***********************************************************************/

package control;

import java.util.Vector;

import view.EquipeEdit;
import view.EquipeView;
import view.JoueurEdit;
import view.JoueurView;
import view.ListeEquipesView;
import main.JMain;
import model.Equipe;
import model.Joueur;
import model.Entraineur;
import model.Util;

/** @pdOid 42a54baa-0e8d-427e-8771-dd1fc3801e1e */
public class EquipeControler {
	/** @param equipe
	 * @pdOid 2dd9cc9c-135b-408e-be89-445a3c507ac2 */
	public static boolean save(Equipe equipe) throws Exception {
		// TODO: implement
		if(Util.isEmptyOrNull(equipe.getNom()))
			throw new Exception("Veuillez donner un nom");
		if(equipe.getStade() == null)
			throw new Exception("Veuillez sélectionner un stade");

		boolean saved = Equipe.save(equipe);
		if(saved)
			EquipeControler.viewEquipe(equipe);
		return false;
	}

	/** @param equipe
	 * @pdOid a43d8aff-46ca-4444-aafb-ec95f357596e */
	public static boolean delete(Equipe equipe) {
		// TODO: implement
		return false;
	}

	/** @param text 
	 * @param format
	 * @pdOid 2352cd68-9042-469e-950e-f148aee33137 */
	public static boolean check(String text, String format) {
		return GenericControler.check(text, format);
	}
	
	public static void viewListeEquipes(){
		Vector<Equipe> equipes = Equipe.getEquipes();
		ListeEquipesView view = new ListeEquipesView(equipes);
		JMain.fenPrincipale.closeAllViews();
		JMain.fenPrincipale.setCurrentView(view);
	}

	/** @param equipe
	 * @pdOid e95053b6-e99c-4c05-8b10-05603af36254 */
	public static void viewEquipe(Equipe equipe) {
		// TODO: implement
		EquipeView view = new EquipeView(equipe);
		javax.swing.JInternalFrame currentView = JMain.fenPrincipale.getCurrentView();
		if(currentView instanceof EquipeEdit)
			JMain.fenPrincipale.closeCurrentView();
		JMain.fenPrincipale.setCurrentView(view);
	}

	/** @param equipe
	 * @pdOid 6cd9acdd-e147-4a5c-bdb7-d45ae7086352 */
	public static void editEquipe(Equipe equipe) {
		// TODO: implement
		EquipeEdit view = new EquipeEdit(equipe);
		JMain.fenPrincipale.closeCurrentView();
		JMain.fenPrincipale.setCurrentView(view);
	}

	/** @pdOid 02e9e210-d22e-49af-8e94-33f1c37433f4 */
	public static void editNewEquipe() {
		// TODO: implement
		Equipe equipe = Equipe.newEquipe();
		EquipeEdit view = new EquipeEdit(equipe);
		JMain.fenPrincipale.setCurrentView(view);
	}

	/** @param joueur
	 * @pdOid 71bd4802-493d-48ab-bcba-0d77136e06b6 */
	public static void viewJoueur(Joueur joueur) {
		JoueurControler.viewJoueur(joueur);
	}

	/** @param entraineur
	 * @pdOid 3379cdf6-179e-42f0-ab2f-ed416d7faa8d */
	public static void viewEntraineur(Entraineur entraineur) {
		EntraineurControler.viewEntraineur(entraineur);
	}

}