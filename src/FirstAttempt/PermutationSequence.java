package FirstAttempt;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	// http://www.cnblogs.com/springfor/p/3896201.html
	public String getPermutation(int n, int k) {
        k -= 1;  // 让k变成index，起始于0.
		
		List<Integer> nums = new ArrayList<Integer>();  
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		
		
		int fact = 1;
		for (int i = 2; i < n; i++) {
			fact *= i;  // 求出(n-1)!
		}
		
		StringBuilder res = new StringBuilder();
		for (int i = n-1; i >= 0; i--) {  // 循环n次
			int pos = k / fact;
			int num = nums.get(pos);
			res.append(num);  // num用过了，所以要从nums中抹去，不能再用了
			nums.remove(pos);
			
			// 更新
			k = k % fact;
			if (i != 0) fact = fact / i;	// 从 x! 变成 (x-1)!
		}
		
		return res.toString();
    }
}
