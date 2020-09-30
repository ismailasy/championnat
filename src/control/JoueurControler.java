/***********************************************************************
 * Module:  JoueurControler.java
 * Author:  Lenovo
 * Purpose: Defines the Class JoueurControler
 ***********************************************************************/

package control;

import main.JMain;
import model.Joueur;
import model.Contrat;
import model.Util;

import java.util.*;

import view.IEditComponent;
import view.JoueurEdit;
import view.JoueurView;

/** @pdOid 1f623443-b7ea-4017-bc5c-985df6242a00 */
public class JoueurControler {
	/** @param joueur
	 * @pdOid 4d8a830f-60c0-4b92-b016-ab930d71c171 */
	public static boolean save(Joueur joueur) throws Exception {
		// TODO: implement
		if(Util.isEmptyOrNull(joueur.getNom()))
			throw new Exception("Veuillez donner un nom");
		if(Util.isEmptyOrNull(joueur.getPrenom()))
			throw new Exception("Veuillez donner un prénom");
		if(Util.isEmptyOrNull(joueur.getLicence()))
			throw new Exception("Veuillez donner un numéro de licence");
		if(joueur.getLieuNaiss() == null)
			throw new Exception("Veuillez sélectionner un pays de naissance");
		
		boolean saved = Joueur.save(joueur);
		if(saved)
			JoueurControler.viewJoueur(joueur);
		return false;
	}

	/** @param joueur
	 * @pdOid 6527b486-69e8-4cc3-8659-3951b461bb7b */
	public static boolean delete(Joueur joueur) throws Exception {
		// TODO: implement
		return false;
	}

	/** @param text 
	 * @param format
	 * @pdOid 4f915282-511c-41ed-bdae-7bfd7d8c9e19 */
	public static boolean check(String text, String format) {
		return GenericControler.check(text, format);
	}

	/** @param joueur
	 * @pdOid 821ed4f5-ae36-4a87-bac6-d92c921abc0b */
	public static void viewJoueur(Joueur joueur) {
		// TODO: implement
		JoueurView view = new JoueurView(joueur);
		javax.swing.JInternalFrame currentView = JMain.fenPrincipale.getCurrentView();
		if(currentView instanceof JoueurEdit)
			JMain.fenPrincipale.closeCurrentView();
		JMain.fenPrincipale.setCurrentView(view);
	}

	/** @param joueur
	 * @pdOid fa07fdb8-398b-4f0a-b8c0-3c5482c1e9aa */
	public static void editJoueur(Joueur joueur) {
		// TODO: implement
		JoueurEdit view = new JoueurEdit(joueur);
		JMain.fenPrincipale.closeCurrentView();
		JMain.fenPrincipale.setCurrentView(view);
	}

	/** @pdOid e6060ecb-bad1-40fe-991a-4059abbf1a22 */
	public static void editNewJoueur() {
		// TODO: implement
		Joueur joueur = Joueur.newJoueur();
		JoueurEdit view = new JoueurEdit(joueur);
		JMain.fenPrincipale.setCurrentView(view);
	}

	/** @param contrat
	 * @pdOid 1c992d5d-c82f-48da-84d7-6ae9cbd76ebb */
	public static void viewContrat(Contrat contrat) {
		ContratControler.viewContrat(contrat);
	}
}