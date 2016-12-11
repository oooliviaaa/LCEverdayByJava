package LLLLLLLLL;

public class SquareRoot {

	public boolean isSquare(int num) {
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
	
	// implement sqrt()
	// binary search: https://discuss.leetcode.com/topic/8680/a-binary-search-solution/2
	public int sqrt(int x) {
		if (x <= 0) return 0;
        int left = 1;
        int right = x;
        
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {   // 防止TLE ！！！！！
                right = mid - 1;
            } else if ((mid+1) > x / (mid+1)) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
    }	
	
	///////////////
	
	public static double mySqrt(double x, int digit) {
		double start = 0;
		double end = x < 1 ? 1.0 : x;
		double diff = 1 / Math.pow(10, digit);
		while (start < end - diff) {
			double mid = start + (end - start) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid > x / mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return (start + end) / 2;
	}
}
