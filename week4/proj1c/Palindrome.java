
/* Palindrome class */
public class Palindrome {

	/* a Deque where the characters in the deque appear 
	 * in the same order as in the word. */
	public static Deque<Character> wordToDeque(String word) {
		Deque<Character> DequeChar = new LinkedListDequeSolution<Character>();
		for(int i = 0; i < word.length(); i++) {
			DequeChar.addLast(word.charAt(i));
		}
		return DequeChar;
	}

	/* Return true if the given word is a palindrome
	 * Any word of length 1 or 0 is a palindrome. */
	/* Basic isPalindrome method (OffByZero)
	public static boolean isPalindrome(String word) {
		int length = word.length();
		if(length == 0 || length == 1) return true;

		Deque<Character> check = wordToDeque(word);
		for(int i = 0; i < length/2; i++) {
			if(check.getRecursive(i) != check.getRecursive(length - 1 - i))
				return false;
		}
		return true;
	}
	*/

	/* Generallized isPalindrome method
	 * The method will return true if the word is a palindrome (OffByN) 
	 * according to the character comparison test provided by the 
	 * CharacterComparator passed in as argument cc */
	public static boolean isPalindrome(String word, CharacterComparator cc) {
		int length = word.length();
		if(length == 0 || length == 1) return true;

		Deque<Character> check = wordToDeque(word);
		for(int i = 0; i < length/2; i++) {
			if(!cc.equalChars(check.get(i), check.get(length - 1 - i)))
				return false;
		}
		return true;
	}

}


