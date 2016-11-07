package LLLLLLLLL;

import java.util.Random;

public class ShuffleAnArray {
	
	public void shuffleArray(int[] a) {
		if (a == null || a.length == 0) return;
		Random r = new Random();
		
		for (int i = 0; i < a.length; i++) {
			int random = r.nextInt(a.length - i);
			int tmp = a[i];
			a[i] = a[i+random];
			a[i+random] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		ShuffleAnArray sa = new ShuffleAnArray();
		sa.shuffleArray(a);
		for (int i : a) System.out.print(i + " ");
	}
}
