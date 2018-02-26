public class maximum {
	public static int max(int[] m) {
		int result = m[0];
		int i = 0;
		while(i < m.length) {
			if(m[i] > result) {
				result = m[i];
			}
			i += 1;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] numbers = new int[] {9, 2, 5, 4, 5, 7, 8, 10, 0};
		System.out.println(max(numbers));
	}
}