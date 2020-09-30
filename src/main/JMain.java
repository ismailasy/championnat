package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import view.EquipeEdit;
import view.IEditComponent;
import view.IViewComponent;
import view.ListeEquipesView;

public class JMain  extends JFrame {
	private static final long serialVersionUID = 1L;

	public static String titre = "SenFoot 1.0";
	public static String icone = "/Images/close.png";
	public static JMain fenPrincipale = null;


	private CustomToolBar toolbar;
	private JDesktopPane desktopPane;

	public JMain(){
		super();
		this.setTitle(titre); 

		if(icone != null){
			try{
				Image iconeImg = (new ImageIcon(getClass().getResource(icone))).getImage();
				this.setIconImage(iconeImg);
			}
			catch(Exception e){}
		}

		JMain.fenPrincipale = this;

		this.setLayout(new BorderLayout());
		JPanel contentPane = (JPanel)this.getContentPane();

		toolbar = new CustomToolBar(this);
		contentPane.add(toolbar,BorderLayout.NORTH);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.gray);
		desktopPane.setMinimumSize(new Dimension(800,600));
		JScrollPane jsp = new JScrollPane(desktopPane);	
		contentPane.add(jsp, BorderLayout.CENTER);

		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, (int)tailleEcran.getWidth(), (int)tailleEcran.getHeight());

		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		/*JInternalFrame test = new JInternalFrame("Test", false, false, false, false);
		test.setFrameIcon(new ImageIcon(getClass().getResource(JMain.icone)));  	  
		test.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		test.setBounds(0, 0, (int)tailleEcran.getWidth(), (int)tailleEcran.getHeight());
		try{
			test.setMaximum(true);
		}
		catch(Exception exc){}
		test.setVisible(true);

		this.desktopPane.add(test);*/
	}

	protected void closeView(JInternalFrame view){
		if(view == null)
			return;

		if(view instanceof IEditComponent){
			IEditComponent editComponent = (IEditComponent)view;
			if(editComponent.isModified()){
				int option=JOptionPane.showInternalConfirmDialog(this,"Les données en cours ont été modifiées. Voulez-vous les enregistrer ?", JMain.titre, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(option==JOptionPane.YES_OPTION)
					editComponent.save();
			}
			this.desktopPane.remove(view);
			editComponent.close();
		}
		else
			if(view instanceof IViewComponent){
				this.desktopPane.remove(view);
				((IViewComponent)view).close();
			}
		
		System.gc();

		JInternalFrame[] frames = this.desktopPane.getAllFrames();
		if(frames != null && frames.length>0)
			desktopPane.setSelectedFrame(frames[0]);
		
		this.refreshToolBar();
	}

	public void closeAllViews(){
		JInternalFrame[] views = this.desktopPane.getAllFrames();
		if(views == null)
			return;

		for(int i=0; i < views.length; i++)
			this.closeView(views[i]);
	}

	public void closeCurrentView(){
		JInternalFrame view = this.desktopPane.getSelectedFrame();
		this.closeView(view);
	}

	public void setCurrentView(JInternalFrame view){
		if(view == null)
			return;

		view.setVisible(true);		
		this.desktopPane.add(view, 0);
		
		desktopPane.setSelectedFrame(view);
		this.refreshToolBar();
	}

	public JInternalFrame getCurrentView(){
		return this.desktopPane.getSelectedFrame();
	}

	protected void refreshToolBar(){
		JInternalFrame view = this.desktopPane.getSelectedFrame();

		if(view != null){
			boolean isViewComponent = view instanceof IViewComponent;
			boolean isEditComponent = view instanceof IEditComponent;

			this.toolbar.setEditButtonEnabled(isViewComponent && ((IViewComponent)view).isEditable());
			this.toolbar.setPrintButtonEnabled(isViewComponent && ((IViewComponent)view).isPrintable());
			this.toolbar.setAddNewButtonEnabled(isViewComponent);
			this.toolbar.setDeleteButtonEnabled(isViewComponent);
			this.toolbar.setSaveButtonEnabled(isEditComponent);

			if(view instanceof ListeEquipesView){
				this.toolbar.setAddNewButtonEnabled(false);
				this.toolbar.setDeleteButtonEnabled(false);
			}
			
			this.repaint();
		}
	}

	public static void main(String[] args) {
		try{ 
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} 
		catch(Exception e){}

		new JMain();
	}

}
