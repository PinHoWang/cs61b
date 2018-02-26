public class Triangle {
	public static void main(String[] args) {
		int i = 0;
		while(i < 5) {
			int j = 0;
			while(j < i+1) {
				System.out.print('*');
				j += 1;
			}
			System.out.println();
			i += 1;
		}
	}
}