package FirstAttempt;

public class Sqrt {
	public int mySqrt(int x) {
        if (x <= 0) return 0;
        int left = 1;
        int right = x;
        
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {                 // 防止TLE ！！！！！
                right = mid - 1;
            } else if ((mid+1) > x / (mid+1)) {  // 防止TLE ！！！！！
                return mid;
            } else {
                left = mid + 1;
            }
        }
    }
}
