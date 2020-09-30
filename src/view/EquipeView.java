/***********************************************************************
 * Module:  EquipeView.java
 * Author:  Lenovo
 * Purpose: Defines the Class EquipeView
 ***********************************************************************/

package view;

import main.JMain;
import model.Equipe;
import model.Stade;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import control.EquipeControler;

/** @pdOid 26309e9a-894a-477f-b90c-337c0836c763 */
public class EquipeView extends JInternalFrame implements IViewComponent {
	private static final long serialVersionUID = 1L;

	/** @pdOid 6588565d-fecb-4664-a762-26024bdbc2c0 */
	private Equipe equipe;
	protected JLabel jlb_nom, jlb_stade;
	protected JLabel jlb_colorDom1, jlb_colorDom2, jlb_colorExt1, jlb_colorExt2;

	/** @pdOid 0df342b0-112f-4263-95b1-f806f732083a */
	protected void finalize() {
		// TODO: implement
	}

	/** @param equipe
	 * @pdOid 6df4ebb1-ab69-4890-9d45-e0cda5f1b1ee */
	public EquipeView(Equipe equipe) {
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

		jlb_nom = new JLabel();
		jlb_nom.setText(equipe.getNom());

		Color color = new Color(Integer.parseInt(equipe.getRgbColorDom1()));
		jlb_colorDom1 = new JLabel();
		jlb_colorDom1.setBackground(color);
		jlb_colorDom1.setOpaque(true);

		color = new Color(Integer.parseInt(equipe.getRgbColorDom2()));
		jlb_colorDom2 = new JLabel();
		jlb_colorDom2.setBackground(color);
		jlb_colorDom2.setOpaque(true);

		color = new Color(Integer.parseInt(equipe.getRgbColorExt1()));
		jlb_colorExt1 = new JLabel();
		jlb_colorExt1.setBackground(color);
		jlb_colorExt1.setOpaque(true);

		color = new Color(Integer.parseInt(equipe.getRgbColorExt2()));
		jlb_colorExt2 = new JLabel();
		jlb_colorExt2.setBackground(color);
		jlb_colorExt2.setOpaque(true);

		jlb_stade = new JLabel();
		Stade stade = equipe.getStade();
		jlb_stade.setText((stade == null)? "" : stade.getNom());

		GridLayout layout = new GridLayout(6,2);
		this.setLayout(layout);

		Container contentPane = this.getContentPane();
		contentPane.add(new JLabel("Nom:"));
		contentPane.add(jlb_nom);
		contentPane.add(new JLabel("Stade:"));
		contentPane.add(jlb_stade);
		contentPane.add(new JLabel("Couleur à domicile:"));
		contentPane.add(jlb_colorDom1);
		contentPane.add(new JLabel("Couleur à domicile:"));
		contentPane.add(jlb_colorDom2);
		contentPane.add(new JLabel("Couleur à l'extérieur:"));
		contentPane.add(jlb_colorExt1);
		contentPane.add(new JLabel("Couleur à l'extérieur:"));
		contentPane.add(jlb_colorExt2);
	}

	/** @pdOid 06b72b7a-9c29-47a1-8815-778f2748a71f */
	public boolean isPrintable() {
		// TODO: implement
		return false;
	}

	/** @pdOid 1e309ce7-811a-4589-9dae-63acc8e8da69 */
	public boolean isEditable() {
		// TODO: implement
		return true;
	}

	/** @pdOid 5e556c5f-d82a-425e-bea3-6353c960e86a */
	public void printView() {
		// TODO: implement
	}

	/** @pdOid 4b5da828-c530-4b92-b413-a8839b71945a */
	public void editView() {
		// TODO: implement
		EquipeControler.editEquipe(equipe);
	}

	/** @pdOid 57d568a4-ce28-49a1-8119-a9987e77bf89 */
	public void close() {
		// TODO: implement
		this.dispose();
	}

}