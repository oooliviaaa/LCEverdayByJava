package InterestingQuestions;

public class RecoverRotateArray {

	
	public void solution(int[] input) {
		if (input == null || input.length <= 1) return;
		
		int i = 0;
		for (; i < input.length-1; i++) {
			if (input[i] > input[i+1]) {
				break;
			}
		}
		if (i == input.length-1) return;   // not a rotated array
		
		mirrorArray(input, 0, i);
		mirrorArray(input, i+1, input.length-1);
		mirrorArray(input, 0, input.length-1);
	}
	
	private void mirrorArray(int[] input, int i, int j) {
		while (i < j) {
			int tmp = input[i];
			input[i] = input[j];
			input[j] = tmp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		int[] input = {4,5,6,7,1,2,3};
		RecoverRotateArray rr = new RecoverRotateArray();
		rr.solution(input);
		
		for (int i : input) System.out.println(i);
	}
}
