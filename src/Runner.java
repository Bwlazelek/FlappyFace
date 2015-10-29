import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Runner {
	/**
	 * 
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("Flappy Face");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		Container pane = f.getContentPane();
		f.setLayout(new BorderLayout());
		f.setVisible(true);

		GamePanel gp = new GamePanel();
		pane.add(gp, BorderLayout.CENTER);

	//	MainMenu mm = new MainMenu(gp);
	//	mm.setBounds(0, 0, 500, 500);
	//	gp.add(mm);

		f.setVisible(true);

	}

}