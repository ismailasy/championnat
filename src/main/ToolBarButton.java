package main;

import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolBarButton extends JButton {
	private static final long serialVersionUID = 1L;
	private static final Insets margins = new Insets(0, 0, 0, 0);

	  public ToolBarButton(Icon icon) {
	    super(icon);
	    setMargin(margins);
	    setVerticalTextPosition(BOTTOM);
	    setHorizontalTextPosition(CENTER);
	  }

	  public ToolBarButton(String imageFile) {
	    this(new ImageIcon(imageFile));
	  }

	  public ToolBarButton(String imageFile, String text) {
	    this(new ImageIcon(imageFile));
	    setText(text);
	  }
}
