import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GamePanel gp;
	private Flappybird fp;
	private Ground[] ground = new Ground[2];;
	private JLabel score = new JLabel("0");
	private Obstacles[] obs = new Obstacles[3];;
	private boolean isFly;
	private javax.swing.Timer timer;
	private ImageIcon Background = new ImageIcon("imgBackground/bakcground.png");
	private MainGamePanel mmp;
	private ImageIcon temp;
	private JLabel instruction = new JLabel("GET READY!");
	private JLabel tap = new JLabel("TAP!");
	public boolean isGif = true;
	public static boolean isdeath = false;

	public MainGamePanel(GamePanel p, ImageIcon x) {
		mmp = this;
		gp = p;
		fp = new Flappybird();
		timer = new javax.swing.Timer(13, new Move());
		temp = x;
		addMouseListener(new FlappyMouse());
		setBackground(Color.PINK);
		Ground();
		Obstacle();
		Label();
	}

	public void Obstacle() {
		int distance = 550;
		for (int i = 0; i < 3; i++) {
			obs[i] = new Obstacles(gp, distance);
			distance += 210;
		}
	}

	public void Ground() {
		int distance = 0;
		for (int i = 0; i < 2; i++) {
			ground[i] = new Ground(distance, 400);
			distance += 500;
		}
	}

	public void Label() {
		// score keep track
		score.setBounds(240, 30, 100, 30);
		score.setFont(gp.getMyfont());
		add(score);
		// tap!
		tap.setBounds(140, 230, 100, 30);
		tap.setFont(gp.getTap());
		add(tap);
		// get Ready!!!
		instruction.setBounds(180, 120, 150, 30);
		instruction.setFont(gp.getTap());
		instruction.setForeground(Color.ORANGE);

		add(instruction);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Background.paintIcon(this, g, 0, 0);

		for (int x = 0; x < 2; x++) {// Paints the ground
			ground[x].drawGround(this, g);
		}

		for (int i = 0; i < 3; i++) {// Paints the Obstacles
			obs[i].drawObstacle(g);

		}
		fp.drawBird(this, g, fp.getGif(), temp);// Paints the FlappyFace
		score.setBounds(240, 30, 100, 30);
		score.setText(gp.getScore());

	}

	private class Move implements ActionListener {

		public Move() {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			checkFly();
			Gravity();
			MoveGround();
			MoveObstacle();
			TestCollision();
			Jump();

		}

		public void MoveGround() {
			for (int i = 0; i < 2; i++) {// Paints the Obstacles
				ground[i].addGroundX(-1);

				if (ground[i].getGroundX() < -495) {
					ground[i].setGroundX(500);
				}
			}
			repaint();
		}

		public void Jump() {
			fp.setBirdY(Flappybird.vertical_speed);
			if (isFly) {

				fp.setGif(-1);

				if (fp.getGif() <= 0)
					fp.setGif(0);
			}
			repaint();

		}

		public void Gravity() {
			Flappybird.vertical_speed = Flappybird.vertical_speed
					+ Flappybird.gConstant;
			if (!isFly) {

				fp.setGif(1);

				if (fp.getGif() >= 22)
					fp.setGif(22);
			}
			if (Flappybird.vertical_speed >= Flappybird.TERMINAL_VELOCITY)
				Flappybird.vertical_speed = Flappybird.TERMINAL_VELOCITY;

			repaint();
			fp.setBirdY(Flappybird.vertical_speed);
		}

		public void checkFly() {
			if (Flappybird.vertical_speed <= 1) {
				isFly = true;
			} else
				isFly = false;
		}

		public void MoveObstacle() {
			for (int i = 0; i < 3; i++) {
				obs[i].addObsX(-1);
				if (obs[i].getObsX() <= -50) {
					obs[i].setObsX(550);
					obs[i].randY1();
					obs[i].addY2();
				}
				repaint();
			}

		}

		public void TestCollision() {
			for (int i = 0; i < 3; i++) {
				if (fp.getBirdX2() >= obs[i].getObsX()
						&& fp.getBirdX1() <= (obs[i].getObsX() + 50)) {
					if (!(fp.getBirdY2() < obs[i].getY2() && fp.getBirdY1() > obs[i]
							.getY1())) {
						GameOverPanel x = new GameOverPanel(gp, mmp, gp.getScore(), gp.getHighScore());
						x.setBounds(0, 0, 500, 500);
						gp.repaint();
						add(x);
						remove(score);
						timer.stop();
						isdeath = true;

					}
					if (obs[i].getObsX() + 30 == fp.getBirdX1())
						gp.addScore();
				}

			}
			if (fp.isGround()) {
				GameOverPanel x = new GameOverPanel(gp, mmp, gp.getScore(), gp.getHighScore());
				x.setBounds(0, 0, 500, 500);
				remove(score);
				gp.repaint();
				isdeath = true;
				add(x);
				timer.stop();

			}
			repaint();
		}

	}

	private class FlappyMouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		if (!isdeath) {
				
				Flappybird.vertical_speed = -2;
				fp.setJump(true);
				remove(instruction);
				remove(tap);
				timer.start();
				repaint();
			}
		}

		public void mouseReleased(MouseEvent e) {
		}

	}
}
