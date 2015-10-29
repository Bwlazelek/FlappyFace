import java.awt.Font;


import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MyJButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font myfont = new Font("Lucida Sans Typewriter", Font.PLAIN, 14);

	public MyJButton(ImageIcon x) {
		super(x);
		setBorderPainted(false);
		// setFocusPainted(false);
		setContentAreaFilled(false);

		setFont(myfont);

	}
}