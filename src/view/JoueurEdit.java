/***********************************************************************
 * Module:  JoueurEdit.java
 * Author:  Lenovo
 * Purpose: Defines the Class JoueurEdit
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import control.JoueurControler;

/** @pdOid e453fb97-c814-4565-9d05-495e94954075 */
public class JoueurEdit extends JInternalFrame implements IEditComponent {
	private static final long serialVersionUID = 1L;
	/** @pdOid 06831f8f-3bf8-4ef3-9f00-b09817995142 */
	private Joueur joueur;
	// idpersonne, numero_licence, date_licence, nom, prenom, photo, date_naissance, idpays_naissance
	protected JTextField jtf_numeroLicence, jtf_nom, jtf_prenom;
	protected JDatePickerImpl jdp_dateLicence, jdp_dateNaissance;
	protected JComboBox<Pays> jcb_paysNaissance;

	/** @pdOid 5cf58ebc-676f-49f6-9f94-aedb386429a3 */
	protected void finalize() {
		// TODO: implement
	}

	/** @param joueur
	 * @pdOid 533959b3-af82-4c6b-b3ec-2d3cd32afb2a */
	public JoueurEdit(Joueur joueur) {
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

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		UtilDateModel model_dateLicence = new UtilDateModel();
		JDatePanelImpl datePanel_dateLicence = new JDatePanelImpl(model_dateLicence, p);
		jdp_dateLicence = new JDatePickerImpl(datePanel_dateLicence, new DateLabelFormatter());
		model_dateLicence.setValue(joueur.getDateAcquisition());

		UtilDateModel model_dateNaissance = new UtilDateModel();
		JDatePanelImpl datePanel_dateNaissance = new JDatePanelImpl(model_dateNaissance, p);
		jdp_dateNaissance = new JDatePickerImpl(datePanel_dateNaissance, new DateLabelFormatter());
		model_dateNaissance.setValue(joueur.getDateNaissance());

		jtf_nom = new JTextField();
		jtf_nom.setText(joueur.getNom());

		jtf_prenom = new JTextField();
		jtf_prenom.setText(joueur.getPrenom());

		jtf_numeroLicence = new JTextField();
		jtf_numeroLicence.setText(joueur.getLicence());

		Vector<Pays> allPays = Pays.getPays();
		jcb_paysNaissance = new JComboBox<Pays>(allPays);
		Pays lieuNaissance = joueur.getLieuNaiss();
		if(lieuNaissance != null){
			Pays paysNaissance = null;
			for(Pays pays : allPays)
				if(pays.getIdPays() == lieuNaissance.getIdPays()){
					paysNaissance = pays;
					break;
				}
			if(paysNaissance != null)
				jcb_paysNaissance.setSelectedItem(paysNaissance);
		}

		GridLayout layout = new GridLayout(3,2);
		this.setLayout(layout);

		Container contentPane = this.getContentPane();
		contentPane.add(new JLabel("Nom:"));
		contentPane.add(jtf_nom);
		contentPane.add(new JLabel("Prénom:"));
		contentPane.add(jtf_prenom);
		contentPane.add(new JLabel("Date Naissance:"));
		contentPane.add(jdp_dateNaissance);
		contentPane.add(new JLabel("Lieu Naissance:"));
		contentPane.add(jcb_paysNaissance);
		contentPane.add(new JLabel("N° Licence:"));
		contentPane.add(jtf_numeroLicence);
		contentPane.add(new JLabel("Date Licence:"));
		contentPane.add(jdp_dateLicence);
	}

	/** @pdOid a8cee971-5e23-4078-88a3-29093d8ef19f */
	public boolean isModified() {
		// TODO: implement
		return false;
	}

	/** @pdOid 03db3324-a837-49db-be81-75a5da41a8e0 */
	public void save() {
		// TODO: implement
		joueur.setNom(jtf_nom.getText());
		joueur.setPrenom(jtf_prenom.getText());
		joueur.setDateNaissance((Date)jdp_dateNaissance.getModel().getValue());
		if(jcb_paysNaissance.getSelectedIndex() < 0)
			joueur.setLieuNaiss(null);
		else
			joueur.setLieuNaiss((Pays)jcb_paysNaissance.getSelectedItem());
		joueur.setLicence(jtf_numeroLicence.getText());
		joueur.setDateAcquisition((Date)jdp_dateLicence.getModel().getValue());

		try{
			JoueurControler.save(this.joueur);
		}
		catch(Exception exc){
   	        JOptionPane.showMessageDialog(this, exc.getMessage(), JMain.titre,JOptionPane.ERROR_MESSAGE);
		}
	}

	/** @pdOid ee772ebc-6b6f-4787-834f-ad6b93b36a3d */
	public void close() {
		// TODO: implement
		this.dispose();
	}

}