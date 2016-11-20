package FFFFFFFFF;

import java.util.Random;

public class RandomTrurFalse {

	Random r = new Random();
	
	public boolean solution(double d) {
		double left = 0;
		double right = 1;
		int count = 0;
		while (left < right) {
			count++;
			double mid = (left + right) / 2;
			boolean side = r.nextBoolean();
			if (side) {
				right = mid;
			} else {
				left = mid;
			}
		}
		System.out.println("count: " + count);
		return left < d;
	}
	
	public static void main(String[] args) {
		RandomTrurFalse rtf = new RandomTrurFalse();
		boolean res = rtf.solution(0.8);
		System.out.println(res);
	}
}
