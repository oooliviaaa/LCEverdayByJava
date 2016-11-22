package FirstAttempt;

public class RotateFunction {

	// https://discuss.leetcode.com/topic/58616/java-solution-o-n-with-non-mathametical-explaination
	/**
	 * Consider we have 5 coins A,B,C,D,E
	 * 
	 * According to the problem statement
	 * F(0) = (0A) + (1B) + (2C) + (3D) + (4E)
	 * F(1) = (4A) + (0B) + (1C) + (2D) + (3E)
	 * F(2) = (3A) + (4B) + (0C) + (1D) + (2*E)
	 * 
	 * This problem at a glance seem like a difficult problem. I am not very strong in mathematics, so this is how I visualize this problem
	 * We can construct F(1) from F(0) by two step:
	 * Step 1. taking away one count of each coin from F(0), this is done by subtracting "sum" from "iteration" in the code below
	 * after step 1 F(0) = (-1A) + (0B) + (1C) + (2D) + (3*E)
	 * Step 2. Add n times the element which didn't contributed in F(0), which is A. This is done by adding "A[j-1]len" in the code below.
	 * after step 2 F(0) = (4A) + (0B) + (1C) + (2D) + (3E)
	 * At this point F(0) can be considered as F(1) and F(2) to F(4) can be constructed by repeating the above steps.
	 * */
	public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int len = A.length;
        int sum = 0;
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
        	sum += A[i];
        	cur += i * A[i];
        }
        
        int max = cur;
        for (int i = 1; i < len; i++) {
        	cur -= sum;
        	cur += len * A[i-1];
        	max = Math.max(max, cur);
        }
        return max;
    }
}
