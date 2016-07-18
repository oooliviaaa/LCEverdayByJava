package LinkedIn;

public class FormTriangle {

	
	public int[] solution(int[] input) {
		
		int[] res = new int[3];
		
		if (input == null || input.length < 3) {
			return res;
		}
		
		for (int i = 0; i < input.length - 2; i++) {
			int a = input[i];
			int b = input[i+1];
			int c = input[i+2];
			
			if (canFormTriangle(a, b, c)) {
				res[0] = a;
				res[1] = b;
				res[2] = c;
				break;
			}
		}
		return res;
	}
	
	private boolean canFormTriangle(int a, int b, int c) {
		return a+b>c && a+c>b && b+c>a;
	}
	
	
	public static void main(String[] args) {
		FormTriangle ft = new FormTriangle();
		int[] input = new int[]{1,2,3,5,6,7,11,21,51};
		
		int[] res = ft.solution(input);
		for (int i : res) System.out.println(i);
	}
	
}
