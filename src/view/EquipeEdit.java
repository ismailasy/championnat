/***********************************************************************
 * Module:  EntraineurEdit.java
 * Author:  Lenovo
 * Purpose: Defines the Class EntraineurEdit
 ***********************************************************************/

package view;

import main.JMain;
import model.Equipe;
import model.Pays;
import model.Stade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.EquipeControler;
import control.JoueurControler;

/** @pdOid be0a6487-3591-49a3-ba2b-38bb8580122a */
public class EquipeEdit extends JInternalFrame implements IEditComponent, ActionListener, ChangeListener {
	private static final long serialVersionUID = 1L;

	/** @pdOid 800d9124-c38e-462e-b3ae-03dfcc3ce8f3 */
	private Equipe equipe;
	protected JColorChooser colorChooser;
	protected JTextField jtf_nom;
	protected JComboBox<Stade> jcb_stade;
	protected JButton jbt_colorDom1, jbt_colorDom2, jbt_colorExt1, jbt_colorExt2;
	protected JButton selectedButton = null;

	/** @pdOid 44008a2b-a3ab-4181-a891-e8fa35a666cf */
	protected void finalize() {
		// TODO: implement
	}

	/** @param entraineur
	 * @pdOid 4e537c67-400d-4198-8ddc-7049299bf498 */
	public EquipeEdit(Equipe equipe) {
		// TODO: implement
		super("Equipe : " + equipe.getNom(), false, false, false, false);
		this.setFrameIcon(new ImageIcon(getClass().getResource(JMain.icone)));  	  
		this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, (int)tailleEcran.getWidth(), (int)tailleEcran.getHeight());
		try{
			this.setMaximum(true);
		}
		catch(Exception exc){}

		this.equipe = equipe;

		jtf_nom = new JTextField();
		jtf_nom.setText(equipe.getNom());

		Vector<Stade> allStades = Stade.getStades();
		jcb_stade = new JComboBox<Stade>(allStades);
		Stade stadeOfficiel = equipe.getStade();
		if(stadeOfficiel != null){
			Stade stade = null;
			for(Stade s : allStades)
				if(s.getIdStade() == stadeOfficiel.getIdStade()){
					stade = s;
					break;
				}
			if(stade != null)
				jcb_stade.setSelectedItem(stade);
		}

		colorChooser = new JColorChooser(this.getContentPane().getBackground());
		colorChooser.getSelectionModel().addChangeListener(this);
		colorChooser.setBorder(BorderFactory.createTitledBorder("Choose Color"));
		colorChooser.setMaximumSize(new Dimension(300, 300));

		Color color = new Color(Integer.parseInt(equipe.getRgbColorDom1()));
		jbt_colorDom1 = new JButton("Couleur à domicile");
		jbt_colorDom1.setBackground(color);
		jbt_colorDom1.setOpaque(true);
		jbt_colorDom1.addActionListener(this);

		color = new Color(Integer.parseInt(equipe.getRgbColorDom2()));
		jbt_colorDom2 = new JButton("Couleur à domicile");
		jbt_colorDom2.setBackground(color);
		jbt_colorDom2.setOpaque(true);
		jbt_colorDom2.addActionListener(this);

		color = new Color(Integer.parseInt(equipe.getRgbColorExt1()));
		jbt_colorExt1 = new JButton("Couleur à l'extérieur");
		jbt_colorExt1.setBackground(color);
		jbt_colorExt1.setOpaque(true);
		jbt_colorExt1.addActionListener(this);

		color = new Color(Integer.parseInt(equipe.getRgbColorExt2()));
		jbt_colorExt2 = new JButton("Couleur à l'extérieur");
		jbt_colorExt2.setBackground(color);
		jbt_colorExt2.setOpaque(true);
		jbt_colorExt2.addActionListener(this);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2,2));
		pan1.add(new JLabel("Nom:"));
		pan1.add(jtf_nom);
		pan1.add(new JLabel("Stade:"));
		pan1.add(jcb_stade);

		JPanel pan21 = new JPanel();
		pan21.setLayout(new GridLayout(4, 2));
		pan21.add(new JLabel("Couleur à domicile:"));
		pan21.add(jbt_colorDom1);
		pan21.add(new JLabel("Couleur à domicile:"));
		pan21.add(jbt_colorDom2);
		pan21.add(new JLabel("Couleur à l'extérieur:"));
		pan21.add(jbt_colorExt1);
		pan21.add(new JLabel("Couleur à l'extérieur:"));
		pan21.add(jbt_colorExt2);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		pan2.add(pan21, BorderLayout.WEST);
		pan2.add(this.colorChooser, BorderLayout.EAST);
		
		Container contentPane = this.getContentPane();
		contentPane.add(pan1, BorderLayout.NORTH);
		contentPane.add(pan2, BorderLayout.CENTER);
	}

	/** @pdOid 91c6e9b6-0091-47ec-9c64-31a870881405 */
	public boolean isModified() {
		// TODO: implement
		return false;
	}

	/** @pdOid 23076d3f-f265-435e-9c59-7d6e8bd8cf3c */
	public void save() {
		// TODO: implement
		this.equipe.setNom(jtf_nom.getText());
		if(jcb_stade.getSelectedIndex() < 0)
			this.equipe.setStade(null);
		else
			this.equipe.setStade((Stade)jcb_stade.getSelectedItem());
		this.equipe.setRgbColorDom1("" + jbt_colorDom1.getBackground().getRGB());
		this.equipe.setRgbColorDom2("" + jbt_colorDom2.getBackground().getRGB());
		this.equipe.setRgbColorExt1("" + jbt_colorExt1.getBackground().getRGB());
		this.equipe.setRgbColorExt2("" + jbt_colorExt2.getBackground().getRGB());
		
		try{
			EquipeControler.save(equipe);
		}
		catch(Exception exc){
   	        JOptionPane.showMessageDialog(this, exc.getMessage(), JMain.titre,JOptionPane.ERROR_MESSAGE);
		}
	}

	/** @pdOid 055127b8-c516-4114-9399-ccdcbea9f970 */
	public void close() {
		// TODO: implement
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.selectedButton = (JButton)e.getSource();
		this.colorChooser.setColor(this.selectedButton.getBackground());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if(this.selectedButton != null){
			Color color = colorChooser.getColor();
			this.selectedButton.setForeground(color);
			this.selectedButton.setBackground(color);
		}
	}

}