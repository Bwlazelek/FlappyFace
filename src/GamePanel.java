import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private Font myfont = new Font("Lucida Sans Typewriter", Font.PLAIN, 36);
	private Font tap = new Font("Lucida Sans Typewriter", Font.BOLD, 24);

	private static final long serialVersionUID = 1L;
	private GamePanel gp;
	private int highscore = 0;
	private int score = 0;

	// private JLabel lblScore = new JLabel("0");

	public GamePanel() {
		gp = this;

		setLayout(new BorderLayout());
		// lblScore.setBounds(10, 360, 100, 30);
		// add(lblScore);

		MainMenu mm = new MainMenu(gp);
		mm.setBounds(0, 0, 500, 500);
		add(mm);
	}

	public void addScore() {
		score++;
	}
	public String getHighScore(){
		return "" + highscore;
	}
	public void setHighScore(int i){
		highscore = i;
	}

	public String getScore() {
		return "" + score;
	}

	public Font getMyfont() {
		return myfont;

	}

	public void setScore(int i) {
		score = i;
	}

	public Font getTap() {
		return tap;
	}

}