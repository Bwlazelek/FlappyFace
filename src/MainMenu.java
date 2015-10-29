

import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel gp;
	private MainMenu mm;

	private JButton start = new JButton("Start");
	private JButton stop = new JButton("Quit");
    private ImageIcon Background = new ImageIcon("imgBackground/MainMenuBg.png"); 
	
    public MainMenu(GamePanel p){
    	gp = p;
    	mm = this;
    	button();
	}
	public void button(){
		start.addActionListener(new Start());
		start.setBounds(200, 175, 100, 50);
		gp.add(start);
		
	stop.addActionListener(new Stop());
		stop.setBounds(200, 260, 100, 50);
		gp.add(stop);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Background.paintIcon(this, g, 0,0);
	}
	public void RemoveButton(){
		gp.remove(start);
		gp.remove(stop);

	}
	private class Start implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			gp.remove(mm);
			gp.repaint();
			RemoveButton();	
			PlayerSelection x = new PlayerSelection(gp);
			x.setBounds(0,0, 500, 500);
			gp.add(x);
		}
	}
	private class Stop implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
