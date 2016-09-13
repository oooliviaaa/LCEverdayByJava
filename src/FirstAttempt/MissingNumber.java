package FirstAttempt;

import java.util.Arrays;

public class MissingNumber {

	// http://www.programcreek.com/2014/05/leetcode-missing-number-java/
	// Java Solution 1 - Math
	public int missingNumber(int[] nums) {
	    int sum=0;
	    for(int i=0; i<nums.length; i++){
	        sum+=nums[i];
	    }
	 
	    int n=nums.length;
	    return n*(n+1)/2-sum;
	}
	
	// Java Solution 3 - Binary Search
	public int missingNumber3(int[] nums) {
		Arrays.sort(nums);
		int l=0;
		int r=nums.length-1;
		while(l<=r){
		   int m = (l+r)/2;
		   if(nums[m]>m){
		       r=m-1;
		   }else{  // nums[m]<=m的情况，missing number一定在mid之后
		       l=m+1;
		   }
	    }
	    return r+1;
	}
	
	
	//////////////////////
	
	public int missingNumber_myComplextSolution(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == i) {
        		continue;
        	}
        	
        	int p = i;
        	while (p < nums.length && nums[p] != p) {
        		if (nums[p] == -1) {
        			nums[p] = p;
        			break;
        		}
        		int pos = nums[p];
        		nums[p] = -1;
        		if (pos >= nums.length) break;
        		int next = nums[pos];
        		nums[pos] = pos;
        		p = next;
        	}
        }
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != i) return i;
        }
        
        return nums.length;
    }
	
	public static void main(String[] args) {
		 int[] nums = new int[]{0,1,3,2,5};
		// int[] nums = new int[]{1,0};
		MissingNumber mn = new MissingNumber();
		int res = mn.missingNumber(nums);
		System.out.println(res);
	}
}
