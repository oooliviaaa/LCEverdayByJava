package FFFFFFFFF;

import java.util.Random;

public class RandomTrurFalse {

	Random r = new Random();
	
	public boolean solution(double d) {
		double left = 0;
		double right = 1;
		while (left < right) {
			double mid = (left + right) / 2;
			boolean side = r.nextBoolean();
			if (side) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return left < d;
	}
	
	public static void main(String[] args) {
		RandomTrurFalse rtf = new RandomTrurFalse();
		boolean res = rtf.solution(0.1);
		System.out.println(res);
	}
}
