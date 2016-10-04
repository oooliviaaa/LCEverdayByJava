package FirstAttempt;

import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {

	// https://segmentfault.com/a/1190000003874375
	/**
	 * 二叉搜索树先序遍历序列的特点是降序的部分一定是向左走的，一旦开始升序说明开始向右走了，则上一个降序的点则限定了后面的数的最小值。
	 * 如果继续降序，说明又向左走了，这样等到下次向右走得时候也要再次更新最小值。(此时更新的最小值比之前的最小值大)
	 * 
	 * 这里我们可以用一个栈来暂存之前的路径，
	 * 所以升序时就是将栈中元素不断pop出来直到栈顶大于当前数，而最小值就是最后一个pop出来的数，最后再把该数push进去。
	 * 对于降序的时候，直接向里面push就行了。
	 * 这样，序列无效的条件就是违反了这个最小值的限定。
	 * */
	public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        
        Stack<Integer> stack = new Stack<Integer>();
        int min = Integer.MIN_VALUE;
        for (int p : preorder) {
        	if (p < min) {
        		return false;
        	}
        	
        	while (!stack.isEmpty() && p > stack.peek()) {
        		min = stack.pop();
        	}
        	
        	stack.push(p);
        }
        return true;
    }
	
	
	/////////////////////
	// solution 2 
	// 指针模拟栈法, 时间 O(N) 空间 O(N)
	public boolean verifyPreorder2(int[] preorder) {
        // 用i标记栈顶
        int i = -1, min = Integer.MIN_VALUE;
        for(int num : preorder){
            if(num < min) return false;
            // 同样的解法，但是复用了数组作为栈，每pop一次相当于i--
            while(i >= 0 && num > preorder[i]){
                min = preorder[i--];
            }
            // push相当于i++
            preorder[++i] = num;
        }
        return true;
    }
	
	
	
	//////////////////////
	/////////////////////
	// follow up: Verify Postorder Sequence
	/**
	 * Q：如何验证中序序列？A：中序序列是有序的，只要验证其是否升序的就行了。
	 * Q：如何验证后序序列?
	 * A：后序序列的顺序是left - right - root，而先序的顺序是root - left - right。
	 * 我们同样可以用本题的方法解，不过是从数组的后面向前面遍历，因为root在后面了。
	 * 而且因为从后往前看是先遇到right再遇到left，
	 * 所以我们要记录的是限定的最大值，而不再是最小值，栈pop的条件也变成pop所有比当前数大得数。
	 * 栈的增长方向也是从高向低了
	 * */
	public boolean IsValidPostOrderBst(int[] nums) {
        int i = nums.length;
        int max = Integer.MAX_VALUE;
        for (int j = nums.length - 1; j >= 0; j--)
        {
            if (nums[j] > max) return false;
            while (i <= nums.length - 1 && nums[j] > nums[i])
                max = nums[i++];
            nums[--i] = nums[j];
        }
        return true;
    }
}
