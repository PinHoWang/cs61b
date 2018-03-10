public class SListLauncher {
	public static void main(String[] args) {
		SList<Integer> s1 = new SList<Integer>(5);
		s1.insertFront(10);

		SList<String> s2 = new SList<String>("ape");
		s2.insertFront("apple");
		s2.insertBack("good");
		s2.insertBack("Eat");
		s2.insert("to", 3);
		s2.insert(". YMM!YMM", 5);
		System.out.println(s2.getBack());
		s2.reverse();


		/* Check method */
		System.out.println(s2.size());
		System.out.println(s2.getBack());
	}
} 