package LLLLLLLLLLL;

public class BubbleSort {

	public void solution(int[] array) {
		if (array == null || array.length <= 1) return;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length-i; j++) {
				if (array[j] < array[j-1]) {
					int tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp; 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,6,2,0,5,3,3,5,8,1,9};
		BubbleSort bs = new BubbleSort();
		bs.solution(array);
		for (int a : array) System.out.println(a);
	}
}
