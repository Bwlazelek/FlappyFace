import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerSelection extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GamePanel gp;
	PlayerSelection ps;
	private Faces x = new Faces();
	private javax.swing.Timer timer;
	private JLabel select = new JLabel("Select Your Flappy Player");
	private JButton play = new JButton("Play");
	private ImageIcon leftbar = new ImageIcon("imgBackground/leftbutton.png");
	private ImageIcon rightbar = new ImageIcon("imgBackground/rightbutton.png");
	private boolean moveleft = false;
	private boolean moveright = false;
	private JButton left;
	private JButton right;
	private ArrayList<MyJButton> face = new ArrayList<MyJButton>();
	private ImageIcon flappybird;

	public PlayerSelection(GamePanel p) {
		gp = p;
		ps = this;

		timer = new javax.swing.Timer(20, new ScrollingEffect());

		ScrollButton();
		ps.setBackground(Color.LIGHT_GRAY);
		select.setBounds(175, 50, 200, 50);

		play.setBounds(375, 400, 75, 50);
		play.addActionListener(new PlayGame());

		gp.add(select);
		gp.add(play);

		for (int index = 0; index < x.sizeface(); index++) {
			face.add(new MyJButton(x.getFace(index)));
		}
		FaceButton();
	}

	public void FaceButton() {
		int apartX = 50;
		for (int i = 0; i < face.size(); i++) {
			face.get(i).setBounds(apartX, 150, 125, 150);
			face.get(i).addActionListener(new SelectedPlayer());
			apartX += 160;
		}
		for (int i = 0; i < face.size(); i++) {
			gp.add(face.get(i));
		}
	}

	public void ScrollButton() {
		right = new JButton(rightbar);
		right.setBounds(465, 150, 30, 150);
		right.addMouseListener(new NoticeActive());

		left = new JButton(leftbar);
		left.setBounds(0, 150, 30, 150);
		left.addMouseListener(new NoticeActive());
		gp.add(left);
		gp.add(right);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void remove() {
		gp.remove(select);
		gp.remove(play);
		gp.remove(left);
		gp.remove(right);
		for (int i = 0; i < face.size(); i++) {
			gp.remove(face.get(i));
		}
	}

	private class NoticeActive implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource().equals(left)) {
				timer.start();
				moveleft = false;
				moveright = true;
			} else if (e.getSource().equals(right)) {
				timer.start();
				moveright = false;
				moveleft = true;

			} else {
				moveleft = false;
				moveright = false;
				timer.stop();

			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			timer.stop();

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class SelectedPlayer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(face.get(0))) {
				flappybird = (ImageIcon)  x.getSmallFaces(0);
				Flappybird.defaultBird = true;
			}
			for (int i = 1; i < face.size(); i++) {
				if (e.getSource().equals(face.get(i))) {
					flappybird = (ImageIcon) x.getSmallFaces(i);
					Flappybird.defaultBird = false;
				}
			}

		}

	}

	private class PlayGame implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gp.remove(ps);
			gp.repaint();
			remove();
			MainGamePanel mg = new MainGamePanel(gp, flappybird);
			mg.repaint();
			mg.setBounds(0, 0, 500, 500);
			gp.add(mg);

		}
	}

	private class ScrollingEffect implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			 if (moveleft == true && face.get(face.size()-1).getBounds().x >= 325) {
				for (int i = 0; i < face.size(); i++) {
				face.get(i).setBounds(face.get(i).getBounds().x - 5, 150,125, 150);
				}
			}
			 if (moveright == true && face.get(0).getBounds().x < 50 ) {
				for (int i = 0; i < face.size(); i++) {
					face.get(i).setBounds(face.get(i).getBounds().x + 5, 150,
							125, 150);
				}

			}
		}
	}
}
