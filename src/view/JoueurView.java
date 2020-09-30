/***********************************************************************
 * Module:  JoueurView.java
 * Author:  Lenovo
 * Purpose: Defines the Class JoueurView
 ***********************************************************************/

package view;

import main.JMain;
import model.Joueur;
import model.Pays;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import control.JoueurControler;

/** @pdOid 23d041e4-8077-46e0-b424-3a163df52b0d */
public class JoueurView extends JInternalFrame implements IViewComponent {
	private static final long serialVersionUID = 1L;

	/** @pdOid 03e4fc4f-e782-4178-99e3-57ff4829d074 */
	private Joueur joueur;
	protected JLabel jlb_numeroLicence, jlb_nom, jlb_prenom;
	protected JLabel jlb_dateLicence, jlb_dateNaissance, jlb_paysNaissance;
	
	/** @pdOid c0e41673-f844-4e23-811e-d99258db7eb1 */
	protected void finalize() {
		// TODO: implement
	}

	/** @param joueur
	 * @pdOid 2dd01b24-d7a4-4308-9930-5a258a1cc8f9 */
	public JoueurView(Joueur joueur) {
		// TODO: implement
		super("Joueur : " + joueur.getPrenom() + " " + joueur.getNom(), false, false, false, false);
		this.setFrameIcon(new ImageIcon(getClass().getResource(JMain.icone)));  	  
		this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, (int)tailleEcran.getWidth(), (int)tailleEcran.getHeight());
		try{
			this.setMaximum(true);
		}
		catch(Exception exc){}
		
		this.joueur = joueur;
		
		jlb_nom = new JLabel();
		jlb_nom.setText(joueur.getNom());
		
		jlb_prenom = new JLabel();
		jlb_prenom.setText(joueur.getPrenom());
		
		jlb_dateNaissance = new JLabel();
		jlb_dateNaissance.setText(joueur.getDateNaissance().toString());
		
		jlb_paysNaissance = new JLabel();
		Pays lieuNaissance = joueur.getLieuNaiss();
		jlb_paysNaissance.setText((lieuNaissance == null)? "" : lieuNaissance.getNom());
		
		jlb_numeroLicence = new JLabel();
		jlb_numeroLicence.setText(joueur.getLicence());
		
		jlb_dateLicence = new JLabel();
		jlb_dateLicence.setText(joueur.getDateAcquisition().toString());
		
		GridLayout layout = new GridLayout(6,2);
		this.setLayout(layout);

		Container contentPane = this.getContentPane();
		contentPane.add(new JLabel("Nom:"));
		contentPane.add(jlb_nom);
		contentPane.add(new JLabel("Prénom:"));
		contentPane.add(jlb_prenom);
		contentPane.add(new JLabel("Date Naissance:"));
		contentPane.add(jlb_dateNaissance);
		contentPane.add(new JLabel("Lieu Naissance:"));
		contentPane.add(jlb_paysNaissance);
		contentPane.add(new JLabel("N° Licence:"));
		contentPane.add(jlb_numeroLicence);
		contentPane.add(new JLabel("Date Licence:"));
		contentPane.add(jlb_dateLicence);
	}

	/** @pdOid 69fd8d4f-2c69-4776-bc99-d3a9f08a65ba */
	public boolean isPrintable() {
		// TODO: implement
		return false;
	}

	/** @pdOid d23cdd06-558b-4fb5-b526-83597cac95ab */
	public boolean isEditable() {
		// TODO: implement
		return true;
	}

	/** @pdOid e4919514-4774-4764-9c7e-17c78c85185d */
	public void printView() {
		// TODO: implement
	}

	/** @pdOid fe9156fe-131d-4bd5-8519-292544953627 */
	public void editView() {
		// TODO: implement
		JoueurControler.editJoueur(this.joueur);
	}

	/** @pdOid ced20dae-d422-4b69-b227-bd989a051b10 */
	public void close() {
		// TODO: implement
		this.dispose();
	}

}