import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class Faces {
	private File peoplefaces = new File("SmallFaces//");
	private File largefaces1 = new File("LargeFaces//");

	private ArrayList<String> small_faces_text = new ArrayList<String>(Arrays.asList(peoplefaces.list()));
	private ArrayList<String> large_faces_text = new ArrayList<String>(Arrays.asList(largefaces1.list()));

	private ArrayList<ImageIcon> smallfaces = new ArrayList<ImageIcon>();
	private ArrayList<ImageIcon> largefaces = new ArrayList<ImageIcon>();

	public Faces() {

		for (int i = 0; i < small_faces_text.size(); i++) {
			smallfaces.add(new ImageIcon(peoplefaces.getName() + "/" + small_faces_text.get(i)));
		}
		System.out.println("");

		for (int i = 0; i < large_faces_text.size(); i++) {

			largefaces.add(new ImageIcon(largefaces1.getName() + "/" + large_faces_text.get(i)));
		}

	}

	public int sizeface() {
		return largefaces.size();
	}

	public ImageIcon getFace(int index) {
		return largefaces.get(index);
	}

	public ImageIcon getSmallFaces(int index) {
		return smallfaces.get(index);

	}

}
