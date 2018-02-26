public class fibonacci {
	/* Method fib() */
	public static int fib(int N) {
		int first = 0;
		int second = 1;
		int temp = second;
		if(N == 1) return first;
		else if(N == 2) return second;
		else {
			while(N > 2) {
				temp = first + second;
				first = second;
				second = temp;
				N -= 1;
			}
			return temp;
		}
	}

	/* Method fib2() 
	public static int fib2(int n, int k, int f0, int f1) {
		
	}
	*/

	/* main function */
	public static void main(String[] args) {
		if(args.length != 1) { 
			System.err.println("Usage: java fibonacci [ Nth ]");
		}
		else if(Integer.parseInt(args[0]) < 0) {
			System.out.println("Nth should larger than 0.");
		}
		else {
			System.out.println(fib(Integer.parseInt(args[0])));				
		}
	}
}
