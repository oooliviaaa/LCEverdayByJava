package FirstAttempt;

public class NextPermutation {

	// http://www.programcreek.com/2014/06/leetcode-next-permutation-java/
	public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        
        // 1) scan from right to left, find the first element that is less than its previous one.
        int p = 0;
        for(int i = nums.length-2; i >= 0; i--) {
        	if(nums[i] < nums[i+1]) {
        		p = i;
        		break;
        	}
        }
        
        // 2) scan from right to left, find the first element that is greater than p.
        int q = 0;
        for(int i = nums.length-1; i > p; i--) {
        	if(nums[i] > nums[p]) {
        		q = i;
        		break;
        	}
        }
        
        // special case, nums = {6,5,4,3,2,1} --> {1,2,3,4,5,6}   !!!!!!!!!!
        if(p == 0 && q == 0) {
        	reverseArray(nums, 0, nums.length-1);
        	return;
        }
        
        // 3) swap p and q
        int temp=nums[p];
        nums[p]=nums[q];
        nums[q]=temp;
        
        // 4) reverse elements [p+1, nums.length]
    	if(p < nums.length - 1) {
    		reverseArray(nums, p+1, nums.length-1);
    	}
    }
	
	private void reverseArray(int[] nums, int i, int j) {
		while(i < j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}
	
}
