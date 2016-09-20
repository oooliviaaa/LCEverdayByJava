package FirstAttempt;

public class GasStation {

	// http://www.programcreek.com/2014/03/leetcode-gas-station-java/
	/**
	 * following 2 facts
	 * 1) if the sum of gas >= the sum of cost, then the circle can be completed
	 * 2) if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.
	 * 
	 * sumRemaining tracks the sum of remaining to the current index. 
	 * If sumRemaining < 0, then every index between old start and current index is bad, and we need to update start to be the current index.
	 * */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int preRemain = 0;
        int totalRemain = 0;   // 用来记录 1) if the sum of gas >= the sum of cost, then the circle can be completed
        int start = 0;
        
        for (int i = 0; i < gas.length; i++) {
        	int remain = gas[i] - cost[i];
        	
        	if (preRemain >= 0) {  // 说明可以到达i站
        		preRemain += remain;
        	} else {  // 如果不能到达本站，reset start index to be current
        		preRemain = remain;
        		start = i;
        	}
        	
        	totalRemain += remain;
        }
        return totalRemain >= 0 ? start : -1;
    }
}
