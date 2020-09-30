package main;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;

import control.EquipeControler;

import view.IEditComponent;
import view.IViewComponent;

public class CustomToolBar extends JToolBar implements ActionListener {
	private static final long serialVersionUID = 1L;

	protected ToolBarButton listSaisonsButton, listEquipesButton, listPersonsButton;
	protected ToolBarButton addNewButton, editButton, deleteButton;
	protected ToolBarButton printButton, saveButton, closeButton;

	protected JMain fen;

	public CustomToolBar(JMain fen){ 
		super();
		this.fen=fen;

		String chemin="/Images/";
		Insets margins = new Insets(0, 0, 0, 0);

		listSaisonsButton = new ToolBarButton(new ImageIcon(getClass().getResource(chemin + "listSeasons.png")));
		listSaisonsButton.setToolTipText("Liste des saisons");
		listSaisonsButton.setText("Seasons");
		listSaisonsButton.setMargin(margins);
		listSaisonsButton.addActionListener(this);

		listEquipesButton = new ToolBarButton(new ImageIcon(getClass().getResource(chemin + "listTeams.png")));
		listEquipesButton.setToolTipText("Liste des équipes");
		listEquipesButton.setText("Teams");
		listEquipesButton.setMargin(margins);
		listEquipesButton.addActionListener(this);

		listPersonsButton = new ToolBarButton(new ImageIcon(getClass().getResource(chemin + "listPersons.png")));
		listPersonsButton.setToolTipText("Listes des joueurs et entraineurs");
		listPersonsButton.setText("Players");
		listPersonsButton.setMargin(margins);
		listPersonsButton.addActionListener(this);

		addNewButton = new ToolBarButton(new ImageIcon(getClass().getResource(chemin + "addNew.png")));
		addNewButton.setToolTipText("New");
		addNewButton.setText("New");
		addNewButton.setEnabled(false);
		addNewButton.setMargin(margins);
		addNewButton.addActionListener(this);

		editButton = new ToolBarButton(new ImageIcon(getClass().getResource(chemin + "edit.png"))); 
		editButton.setToolTipText("Edit");
		editButton.setText("Edit");
		editButton.setEnabled(false);
		editButton.setMargin(margins);
		editButton.addActionListener(this);

		deleteButton = new ToolBarButton(new ImageIcon(getClass().getResource(chemin + "delete.png"))); 
		deleteButton.setToolTipText("Delete");
		deleteButton.setText("Delete");
		deleteButton.setEnabled(false);
		deleteButton.setMargin(margins);
		deleteButton.addActionListener(this);

		printButton = new ToolBarButton(new ImageIcon(getClass().getResource(chemin + "print.png")));
		printButton.setToolTipText("Print");
		printButton.setText("Print");
		printButton.setEnabled(false);
		printButton.setMargin(margins);
		printButton.addActionListener(this);

		saveButton = new ToolBarButton(new ImageIcon(getClass().getResource(chemin + "save.png")));
		saveButton.setToolTipText("Save");
		saveButton.setText("Save");
		saveButton.setEnabled(false);
		saveButton.setMargin(margins);
		saveButton.addActionListener(this);

		closeButton = new ToolBarButton(new ImageIcon(getClass().getResource(chemin + "close.png")));
		closeButton.setToolTipText("Close");
		closeButton.setText("Close");
		closeButton.setMargin(margins);
		closeButton.addActionListener(this);

		this.add(listSaisonsButton);
		this.add(listEquipesButton);
		this.add(listPersonsButton);
		addSeparator();
		this.add(addNewButton);
		this.add(editButton);
		this.add(deleteButton);
		addSeparator();
		this.add(saveButton);
		this.add(printButton);
		addSeparator();
		this.add(closeButton);
	}

	public void actionPerformed(ActionEvent act){
		Object source=act.getSource();

		if(source == listSaisonsButton){

		}
		else
			if(source == listEquipesButton){
				EquipeControler.viewListeEquipes();
			}
			else
				if(source == listPersonsButton){

				}
				else
					if(source == addNewButton){

					}
					else
						if(source == editButton){
							JInternalFrame view = JMain.fenPrincipale.getCurrentView();
							if((view != null) && (view instanceof IViewComponent))
								((IViewComponent)view).editView();
						} 
						else
							if(source == deleteButton){

							}
							else
								if(source == saveButton){
									JInternalFrame view = JMain.fenPrincipale.getCurrentView();
									if((view != null) && (view instanceof IEditComponent))
										((IEditComponent)view).save();
								}
								else
									if(source == printButton){
										JInternalFrame view = JMain.fenPrincipale.getCurrentView();
										if((view != null) && (view instanceof IViewComponent))
											((IViewComponent)view).printView();
									}
									else
										if(source == closeButton){
											JMain.fenPrincipale.closeCurrentView();
										}				 			 
	}

	public void setAddNewButtonEnabled(boolean etat){
		addNewButton.setEnabled(etat);
	}

	public void setEditButtonEnabled(boolean etat){
		editButton.setEnabled(etat);
	}

	public void setDeleteButtonEnabled(boolean etat){
		deleteButton.setEnabled(etat);
	}

	public void setSaveButtonEnabled(boolean etat){
		saveButton.setEnabled(etat);
	}

	public void setPrintButtonEnabled(boolean etat){
		printButton.setEnabled(etat);
	}

	public void setCloseButtonEnabled(boolean etat){
		closeButton.setEnabled(etat);
	}

}