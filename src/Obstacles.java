import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Obstacles {
	/**
	 * 
	 */
	private int height2;
	private int obsX;
	private int y1 = (int) (205 * Math.random()) + 50;
	private int y2 = y1 + 83;
	private BufferedImage top_pole;
	private BufferedImage botton_pole;

	public Obstacles(GamePanel p, int x) {
		obsX = x;

		try {
			top_pole = ImageIO.read(new File("imgBackground/TopPole.png"));
			botton_pole = ImageIO.read(new File("imgBackground/BottomPole.png"));

		} catch (IOException ex) {
			System.out.println("Image failed to loaded.");
		}
	}

	public void drawObstacle(Graphics g) {
		height2 = 500 - y2 - 100;
		g.drawImage(top_pole, obsX, 0, 50, y1, null);
		g.drawImage(botton_pole, obsX, y2, 50, height2, null);
	}

	public void addObsX(int i) {
		obsX += i;
	}

	public void setObsX(int i) {
		obsX = i;
	}

	public int getObsX() {
		return obsX;
	}

	public void randY1() {
		y1 = (int) (220 * Math.random()) + 50;
	}

	public void addY2() {
		y2 = y1 + 83;
	}

	public double getY2() {
		return y2;
	}

	public int getHeight2() {
		return height2;
	}

	public int getY1() {
		return y1;
	}
}