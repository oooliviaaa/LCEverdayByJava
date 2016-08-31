package FirstAttempt;

public class PowerOfFour {
	
	// http://www.programcreek.com/2015/04/leetcode-power-of-four-java/
	public boolean isPowerOfFour(int num) {
		while (num > 0) {
			if (num == 1) return true;
			int m = num % 4;
			if (m != 0) return false;
			num /= 4;
		}
		return false;
	}
}
