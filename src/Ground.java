import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Ground {
	private int groundX;
	private int groundY;
	private ImageIcon imgGround = new ImageIcon(
			"imgBackground/ground.png");

	public Ground(int x, int y) {
		groundX = x;
		groundY = y;
	}

	public void drawGround(MainGamePanel mainGamePanel, Graphics g) {
		imgGround.paintIcon(mainGamePanel, g, groundX, groundY);

	}

	public void addGroundX(int i) {
		groundX += i;
	}

	public int getGroundX() {
		return groundX;
	}

	public void setGroundX(int i) {
		groundX = i;
	}
}
