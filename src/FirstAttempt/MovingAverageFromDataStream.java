package FirstAttempt;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {

    /** Initialize your data structure here. */
	
	int size;
	Queue<Integer> queue;
	double avg;
	
    public MovingAverageFromDataStream(int size) {
        this.size = size;
        this.queue = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if (queue.size() < size) {
        	queue.offer(val);
        	int sum = 0;
        	for (int i : queue) {
        		sum += i;
        	}
        	avg = (double) sum / queue.size();
        } else {                             ///// 注意 ！！！！！
        	int first = queue.poll();
        	double minus = (double) first / size;
        	queue.offer(val);
        	double plus = (double) val / size;
        	avg += plus - minus;
        }
        return avg;
    }
}
