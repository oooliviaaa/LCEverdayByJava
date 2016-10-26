package fibonacci;

public class FibonacciDP {

	
	public static int solution(int n) {
		int a = 1;
		int b = 1;
		
		for (int i = 2; i < n; i++) {
			int next = a + b;
			a = b;
			b = next;
		}
		return b;
	}
	
	public static int solution2(int n) {
		if (n <= 2) return 1;
		
		return solution2(n-1) + solution2(n-2);
 	}
	
	public static void main(String[] args) {
		int n = 6;
		
		int res = FibonacciDP.solution(n);
		System.out.println(res);
		
		int res2 = FibonacciDP.solution2(n);
		System.out.println(res2);
	}
}
