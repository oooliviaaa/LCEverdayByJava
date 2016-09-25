package FirstAttempt;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	// http://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/
	/**
	 * keep住大的一半的minHeap，小的一半的maxHeap
	 * */
	
	PriorityQueue<Integer> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half
 
    public FindMedianFromDataStream(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
	
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());  ///// 注意此处！一定要放进两个heap中都排序一遍，保证平衡数量的时候加入的数字是大一半中最小的！
        
        if (minHeap.size() > maxHeap.size()) {
        	maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
        	return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
        	return maxHeap.peek(); ///// !!!!!
        }
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();