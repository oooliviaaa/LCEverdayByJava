package FirstAttempt;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {

	// https://segmentfault.com/a/1190000003903509
	
	// solution 1, priority queue, 时间 O(NlogK) 空间 O(K)
	/**
	 * 维护一个大小为K的最大堆，依此维护一个大小为K的窗口，每次读入一个新数，都把堆中窗口最左边的数扔掉，再把新数加入堆中，这样堆顶就是这个窗口内最大的值。
	 * 结果数组的大小是nums.length + 1 - k， 赋值时下标也是i + 1 - k
	 * */
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());  // heap，用来存数组里的数
        
        int[] res = new int[nums.length-k+1];   ///// !!!!!
        for (int i = 0; i < nums.length; i++) {
        	if (i >= k) {                       ///// !!!!!
        		pq.remove(nums[i-k]);
        	}
        	
        	pq.offer(nums[i]);
        	if (i >= k-1) {                     ///// !!!!!
        		res[i-k+1] = pq.peek();
        	}
        }
        return res;
    }
	
	
	
	
	///////////////
	// solution 2, 双向队列, 时间 O(N) 空间 O(K)
	/**
	 * 当我们遇到新的数时，将新的数和双向队列的末尾比较，如果末尾比新数小，则把末尾扔掉，直到该队列的末尾比新数大或者队列为空的时候才住手。
	 * 这样，我们可以保证队列里的元素是从头到尾降序的，由于队列里只有窗口内的数，所以他们其实就是窗口内第一大，第二大，第三大...的数。
	 * 保持队列里只有窗口内数的方法和上个解法一样，也是每来一个新的把窗口最左边的扔掉，然后把新的加进去。
	 * 然而由于我们在加新数的时候，已经把很多没用的数给扔了，这样队列头部的数并不一定是窗口最左边的数。
	 * 这里的技巧是，我们队列中存的是那个数在原数组中的下标，这样我们既可以知道这个数的值，也可以知道该数是不是窗口最左边的数。
	 * 这里为什么时间复杂度是O(N)呢？因为每个数只可能被操作最多两次，一次是加入队列的时候，一次是因为有别的更大数在后面，所以被扔掉，或者因为出了窗口而被扔掉。
	 * */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		if(nums == null || nums.length == 0) return new int[0];
		Deque<Integer> deque = new LinkedList<Integer>();   // 双向队列, 用来存数组下标
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
        	// 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
        	if (!deque.isEmpty() && (i-k) == deque.peekFirst()) {
        		deque.removeFirst();
        	}
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
        	while (!deque.isEmpty() && nums[deque.peekLast()]< nums[i]) {
        		deque.removeLast();
        	}
            // 加入新数
        	deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
        	if (i >= k-1) {
        		res[i-k+1] = nums[deque.peek()]; 
        	}
        }
        return res;
    }
}
