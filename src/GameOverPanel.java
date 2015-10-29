import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel gp;
	private MainGamePanel mmp;

	private JLabel highscore = new JLabel();
	private JLabel score = new JLabel();
	private JLabel lose = new JLabel("Game Over");
	private int snum;
	private int hsum;
	private JButton replay = new JButton("Try Again");
	private JButton quit = new JButton("QUIT");

	public GameOverPanel(GamePanel g, MainGamePanel x, String score, String highscore) {
		snum = Integer.parseInt(score);
		hsum =Integer.parseInt(highscore);
		mmp = x;
		gp = g;
		CheckScore(snum,hsum);
		setOpaque(false);
		Label();
		button();
	}

	public void button() {
		replay.setBounds(100, 250, 125, 50);
		replay.addActionListener(new GameOver());
		add(replay);
		quit.setBounds(300, 250, 125, 50);
		quit.addActionListener(new GameOver());
		add(quit);

	}
	public void CheckScore(int score, int highscore){
		if(score >= highscore){
			gp.setHighScore(score);
		}
	}
	public void Label() {
		lose.setBounds(160, 50, 250, 100);
		lose.setForeground(Color.RED);
		lose.setFont(gp.getMyfont());
		add(lose);
		
		score.setText("Score: " + snum);
		score.setBounds(205, 110, 170, 100);
		score.setFont(gp.getTap());
		add(score);
		
		hsum =Integer.parseInt(gp.getHighScore());
		highscore.setText("Best:  " + hsum);
		highscore.setBounds(205, 150, 170, 100);
		highscore.setFont(gp.getTap());
		add(highscore);
		
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.ORANGE);
		g.fillRect(132, 125, 250, 125);
		g.setColor(Color.BLACK);
		g.drawRect(132, 125, 250, 125);

	}

	private class GameOver implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(replay)) {
				Flappybird.defaultBird = true;
				MainGamePanel.isdeath = false;
				gp.remove(mmp);
				mmp.repaint();
				gp.repaint();
				gp.setScore(0);
				
				PlayerSelection x = new PlayerSelection(gp);
				x.setBounds(0, 0, 500, 500);
				gp.add(x);

			} else
				System.exit(0);

		}
	}
}
