package FirstAttempt;

public class HIndexII {

	
	// https://segmentfault.com/a/1190000003794831
	// 二分搜索法, 时间 O(logN) 空间 O(1)
	/**
	 * 在升序的引用数数组中，假设数组长为N，下标为i，则N - i就是引用次数大于等于下标为i的文献所对应的引用次数的文章数。
	 * 如果该位置的引用数小于文章数，则说明则是有效的H指数，如果一个数是H指数，那最大的H指数一定在它的后面（因为是升序的）。
	 * 根据这点就可已进行二分搜索了。
	 * 这里min = mid + 1的条件是citations[mid] < n - mid，确保退出循环时min肯定是指向一个有效的H指数。
	 * */
	public int hIndex(int[] citations) {
		int n = citations.length;
		if (n == 0) return 0;
		
		int min = 0;
        int max = n-1;
        
        while (min <= max) {
        	int mid = min + (max - min) / 2;
        	if (citations[mid] < n - mid) { // citations[mid] is a valid h
        		min = mid + 1;
        	} else {
        		max = mid - 1;
        	}
        }
        
        return n-min;
    }
}
