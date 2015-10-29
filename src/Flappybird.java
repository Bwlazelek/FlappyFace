import javax.swing.*;

import java.awt.*;

public class Flappybird {
	/**
	 * 
	 */
	// Coordinates of FlappyBird
	private int birdX = 150;
	private double birdY = 200;

	private int timeGif = 13;
	private boolean isJump = false;
	public static boolean defaultBird = true;
	public static final double gConstant = 0.1;
	public static  double vertical_speed = 0;
	public static final double TERMINAL_VELOCITY = 3;

	private ImageIcon imgflappybird0 = new ImageIcon("flappybird/flappybird0.png");
	private ImageIcon imgflappybird1 = new ImageIcon("flappybird/flappybird1.png");
	private ImageIcon imgflappybird2 = new ImageIcon("flappybird/flappybird2.png");
	private ImageIcon imgflappybird4 = new ImageIcon("flappybird/flappybird4.png");
	private ImageIcon imgflappybird5 = new ImageIcon("flappybird/flappybird5.png");
	private ImageIcon imgflappybird6 = new ImageIcon("flappybird/flappybird6.png");
	private ImageIcon imgflappybird7 = new ImageIcon("flappybird/flappybird7.png");
	private ImageIcon imgflappybirdUP = new ImageIcon("flappybird/flappybirdUP.png");

	public Flappybird() {

	}

	public void drawBird(MainGamePanel mainGamePanel, Graphics g, int gif,
			ImageIcon x) {
		if (defaultBird) {

			if (gif <= 12)
				imgflappybirdUP.paintIcon(mainGamePanel, g, birdX, (int) birdY);

			else if (gif <= 16)
				imgflappybird0.paintIcon(mainGamePanel, g, birdX, (int) birdY);

			else if (gif <= 17)
				imgflappybird1.paintIcon(mainGamePanel, g, birdX, (int) birdY);

			else if (gif <= 18)
				imgflappybird2.paintIcon(mainGamePanel, g, birdX, (int) birdY);

			else if (gif <= 19)
				imgflappybird4.paintIcon(mainGamePanel, g, birdX, (int) birdY);

			else if (gif <= 20)
				imgflappybird5.paintIcon(mainGamePanel, g, birdX, (int) birdY);

			else if (gif <= 21)
				imgflappybird6.paintIcon(mainGamePanel, g, birdX, (int) birdY);

			else
				imgflappybird7.paintIcon(mainGamePanel, g, birdX, (int) birdY);
		} else
			x.paintIcon(mainGamePanel, g, birdX, (int) birdY);

	}

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean x) {
		isJump = x;
	}


	public boolean isGround() {
		if (birdY >= 365) {
			return true;
		}
		return false;
	}

	public double getBirdY1() {
		return birdY;
	}

	public double getBirdY2() {
		return birdY + 28;
	}

	public int getBirdX1() {
		return birdX;
	}

	public int getBirdX2() {
		return birdX + 28;
	}

	public void setBirdY(double i) {
		birdY = birdY + i;
	}

	public int getGif() {
		return timeGif;
	}

	public void setGif(int i) {
		if (i == 0) {
			timeGif = 0;

		} else if (i == 22) {
			timeGif = 22;

		} else {
			timeGif = timeGif + i;
		}
	}
}
