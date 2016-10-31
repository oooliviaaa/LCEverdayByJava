package FirstAttempt;

public class RangeSumQueryImmutable {

	// https://discuss.leetcode.com/topic/60570/2-ms-java-solution-with-explaination-o-n-init-o-1-call
	int[] sum;
	
	public RangeSumQueryImmutable(int[] nums) {
		int n = nums.length;
		sum = new int[n+1];   // 前i个数的和（数0~i-1）
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i-1] + nums[i-1];
		}
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];   // 数i~j的和
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

