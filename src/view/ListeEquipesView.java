/***********************************************************************
 * Module:  ListeEquipesView.java
 * Author:  Lenovo
 * Purpose: Defines the Class ListeEquipesView
 ***********************************************************************/

package view;

import main.JMain;
import model.Equipe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import control.EquipeControler;

/** @pdOid b55c24c2-186f-42fa-8955-2aa46a18b3c6 */
public class ListeEquipesView extends JInternalFrame implements IViewComponent {
	private static final long serialVersionUID = 1L;
	
	protected Vector<Equipe> equipes;
	protected JList<Equipe> listeEquipes;

	/** @pdOid a6383586-e3ec-4ab8-898a-91e2eba44d69 */
	protected void finalize() {
		// TODO: implement
	}

	/** @param equipes
	 * @pdOid e078885c-2b69-4e1b-b954-d188a0e5ff4f */
	public ListeEquipesView(Vector<Equipe> equipes) {
		// TODO: implement
		super("Liste des équipes", false, false, false, false);
		this.setFrameIcon(new ImageIcon(getClass().getResource(JMain.icone)));  	  
		this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, (int)tailleEcran.getWidth(), (int)tailleEcran.getHeight());
		try{
			this.setMaximum(true);
		}
		catch(Exception exc){}

		this.equipes = equipes;
		this.listeEquipes = new JList<Equipe>();
		this.listeEquipes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getContentPane().add(this.listeEquipes, BorderLayout.CENTER);

		if(this.equipes != null){
			DefaultListModel<Equipe> dlm = new DefaultListModel<Equipe>(); 
			for(Equipe equipe : equipes)
				dlm.addElement(equipe);
			this.listeEquipes.setModel(dlm);
		}

		this.listeEquipes.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent mevt){
				// Si on double-clique sur un élément de la liste
				if((javax.swing.SwingUtilities.isLeftMouseButton(mevt))&&(mevt.getClickCount()>1)){
					Equipe equipe = ListeEquipesView.this.listeEquipes.getSelectedValue();
					EquipeControler.viewEquipe(equipe);
				}
			}		
		});
	}

	/** @pdOid 75da65cd-4dd0-42df-9742-ef20a9b9a08f */
	public boolean isPrintable() {
		// TODO: implement
		return true;
	}

	/** @pdOid b52b3c0d-34e7-4124-8c46-c6316fbe7ce8 */
	public boolean isEditable() {
		// TODO: implement
		return false;
	}

	/** @pdOid 621c7b33-cdca-440e-9fed-49740f4b19da */
	public void printView() {
		// TODO: implement
	}

	/** @pdOid 483191d4-98c0-4bc6-9050-e1a5e537acd0 */
	public void editView() {
		// TODO: implement
	}

	/** @pdOid c78f8405-c99a-4064-b1e3-ae6ba3460f3b */
	public void close() {
		// TODO: implement
		this.dispose();
	}

}