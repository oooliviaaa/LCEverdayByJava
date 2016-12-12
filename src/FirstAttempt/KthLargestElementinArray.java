package FirstAttempt;

import java.util.PriorityQueue;

public class KthLargestElementinArray {

	// easy solution: min-heap
	// Time complexity is O(nlog(k)). Space complexity is O(k) for storing the top k numbers.
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		
		for (int i : nums) {
			pq.add(i);
			
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
	
	/////////////////////////////////////////////
	// solution 2: quick sort
	// Average case time is O(n), worst case time is O(n^2).
	public int findKthLargest2(int[] nums, int k) {
		if (k < 1 || nums == null || nums.length == 0) return 0;
		return find(nums.length-k, nums, 0, nums.length-1);
	}
	

	private int find(int k, int[] nums, int bg, int ed) {
		if (bg > ed) return Integer.MAX_VALUE;
		
		int pivot = nums[bg];
		
		int left = bg;
		int right = bg+1;
		
		while (right <= ed) {
			if (nums[left] > nums[right]) {
				left++;
				swap(nums, left, right);
			}
			right++;
		}
		swap(nums, bg, left);
		
		// check where's the pivot position
		if (left == k) {
			return pivot;
		} else if (left > k) {
			return find(k, nums, bg, left-1);
		} else {
			return find(k-left-1, nums, left+1, ed);
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
