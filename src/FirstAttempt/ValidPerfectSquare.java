package FirstAttempt;

public class ValidPerfectSquare {

	// linkedin
	// https://discuss.leetcode.com/topic/49325/a-square-number-is-1-3-5-7-java-code/2
	public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        
        int left = 1;
        int right = num;
        while (left <= right) {
        	long mid = left + (right - left) / 2;
        	long product = mid * mid;
        	if (product == num) {
        		return true;
        	} else if (product > num) {
        		right = (int) mid - 1;
        	} else {
        		left = (int) mid + 1;
        	}
        }
        return false;
    }
}
