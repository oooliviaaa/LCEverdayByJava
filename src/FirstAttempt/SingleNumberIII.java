package FirstAttempt;

public class SingleNumberIII {
	
	// https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72983
	/**
	 * 不妨设最后两个只出现一次的数分别为 x1, x2. 那么遍历数组时根据两两异或的方法可得最后的结果为 x1 ^ x2, 
	 * 如果我们要分别求得 x1 和 x2, 我们可以根据 x1 ^ x2 ^ x1 = x2 求得 x2, 同理可得 x_1. 
	 * 那么问题来了，如何得到x1和x2呢？看起来似乎是个死循环。
	 * 
	 * 这道题的巧妙之处在于利用x1 ^ x2的结果对原数组进行了分组，进而将x1和x2分开了。
	 * 具体方法则是利用了x1 ^ x2不为0的特性，如果x1 ^ x2不为0，那么x1 ^ x2的结果必然存在某一二进制位不为0（即为1），
	 * 我们不妨将最低位的1提取出来，由于在这一二进制位上x1和x2必然相异，
	 * 即x1, x2中相应位一个为0，另一个为1，所以我们可以利用这个最低位的1将x1和x2分开。
	 * 又由于除了x1和x2之外其他数都是成对出现，故与最低位的1异或时一定会抵消.
	 * */
	public int[] singleNumber(int[] nums) {
		
        if (nums == null || nums.length <= 2) return nums;
        
        int[] res = new int[2];
        int xor = 0;
        for (int num : nums) {
        	xor ^= num;
        }
        
        // get the last '1'
        int lastOne = xor & -xor;
        
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
        	if ((num & lastOne) == 0) {   ///// 你不知道otherwise会是什么number，所以只能check是不是0
        		num1 ^= num;
        	} else {
        		num2 ^= num;
        	}
        }
        
        res[0] = num1;
        res[1] = num2;
        return res;
    }
	
	
	public static void main(String[] args) {
//		int a = 26;
//		int res = a & -a;
//		System.out.println((byte)a);
//		System.out.println(-a & (0xff));
//		System.out.println(res);
		int[] nums = new int[]{1,2,1,3,2,5};
		SingleNumberIII sn = new SingleNumberIII();
		int[] res = sn.singleNumber(nums);
		
	}
}
