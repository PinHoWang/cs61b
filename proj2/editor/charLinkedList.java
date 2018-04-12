
package editor;
import java.util.LinkedList;

/* This class record the key list, cursor position, and corresponding coordinate */
public class charLinkedList {
	
	/* Record # line's string */
	private LinkedList<Character> keyList;
	/* Record corresponding xPos of the charactor */
	private LinkedList<Double> xPosList;
	/* Record corresponding yPos of the charactor */
	private LinkedList<Double> yPosList;
	private int curPos;

	public charLinkedList() {
		keyList = new LinkedList<Character>();
		xPosList = new LinkedList<Double>();
		yPosList = new LinkedList<Double>();
		curPos = 0; 
	}

	/* Add the character into the keyList, e.g. Type a key */
	public void add(char c, double kHeight, double kWidth) {
		keyList.add(c);
		xPosList.add(kWidth);
		yPosList.add(kHeight);
		curPos++;
	}

	/* Remove the character */
	public void remove() {
		keyList.removeLast();
		xPosList.removeLast();
		yPosList.removeLast();
		curPos--;
	}

	public String currentString() {
		String s = "";
		for(int i = 0; i < keyList.size(); i++) {
			s += keyList.get(i);
		}
		return s;
	}

}