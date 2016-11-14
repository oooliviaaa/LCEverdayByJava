package LLLLLLLLL;

public class SquareRoot {

	// implement sqrt()
	// binary search: https://discuss.leetcode.com/topic/8680/a-binary-search-solution/2
	public int sqrt(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (true) {
        	int mid = left + (right - left)/2;
            if (mid * mid > x) {
                right = mid - 1;
            } else if ((mid + 1) * (mid + 1) > x) {  // 已经不满足if中的条件了，所以可以直接判断出找到了结果
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
