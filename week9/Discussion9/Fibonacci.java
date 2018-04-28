

import java.util.HashMap;

public class Fibonacci {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public Fibonacci() {
		map.put(0, 0);
		map.put(1, 1);
	}

	// For your reference, fib(0) = 0, fib(1) = 1, fib(2) = 1, ...
	public int fib(int n) {
		if(n == 0) return map.get(0);
		if(n == 1) return map.get(1);
		for(int i = 2; i <= n; i++) {
			map.put(i, (map.get(i-1) + map.get(i-2)));
		}
		return map.get(n);
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fib(10));
	}
}