package FirstAttempt;

public class FindTheDuplicateNumber {

	// https://segmentfault.com/a/1190000003817671 
	// solution 1: binary search 时间 O(NlogN) 空间 O(1)
	/** 用二分法先选取n/2，按照抽屉原理，整个数组中如果小于等于n/2的数的数量大于n/2，说明1到n/2这个区间是肯定有重复数字的。
	 * 比如6个抽屉，如果有7个袜子要放到抽屉里，那肯定有一个抽屉至少两个袜子。
	 * 这里抽屉就是1到n/2的每一个数，而袜子就是整个数组中小于等于n/2的那些数。
	 * 这样我们就能知道下次选择的数的范围，如果1到n/2区间内肯定有重复数字，则下次在1到n/2范围内找，否则在n/2到n范围内找。下次找的时候，还是找一半。
	 * 注意
	 * 1. 我们比较的mid而不是nums[mid]
	 * 2. 因为mid是下标，所以判断式应为cnt > mid，最后返回min
	 */
	public int findDuplicate_BS(int[] nums) {
		int min = 0, max = nums.length - 1;
        while(min <= max){
            // 找到中间那个数
            int mid = min + (max - min) / 2;
            int cnt = 0;
            // 计算总数组中有多少个数小于等于中间数
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    cnt++;
                }
            }
            // 如果小于等于中间数的数量大于中间数，说明前半部分必有重复
            if(cnt > mid){
                max = mid - 1;
            // 否则后半部分必有重复
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
	
	
	////////////////////////
	// solution 2: 映射找环法 时间 O(N) 空间 O(1)
	/**
	 * 该题实际上就是找环路起点的题。和Linked List Cycle II一样。
	 * 我们先用快慢两个下标都从0开始，快下标每轮映射两次，慢下标每轮映射一次，直到两个下标再次相同。
	 * 这时候保持慢下标位置不变，再用一个新的下标从0开始，这两个下标都继续每轮映射一次，当这两个下标相遇时，就是环的起点，也就是重复的数。
	 * */
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		
		int find = 0;
		while (find != slow) {
			slow = nums[slow];
			find = nums[find];
		}
		return find;
	}
	
	
}
