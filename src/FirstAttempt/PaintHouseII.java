package FirstAttempt;

public class PaintHouseII {

	
	// my solution
	public int mySolution(int[][] costs) {
        if (costs != null && costs.length == 0) return 0;
		int len = costs.length;   // house
		int k = costs[0].length;  // color
        
        int premin = 0;
        int preminSec = 0;
        int preminHouse = 0;
        
        for (int i = 0; i < len; i++) {
            int curmin = Integer.MAX_VALUE;
            int curminSec = Integer.MAX_VALUE;
            int curminHouse = -1;
            
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (j == preminHouse ? preminSec : premin);
                if (cost < curmin) {
                    curminSec = curmin;
                    curmin = cost;
                    curminHouse = j;
                } else if (cost < curminSec) {
                    curminSec = cost;
                }
            }
            
            premin = curmin;
            preminSec = curminSec;
            preminHouse = curminHouse;
        }
        return premin;
    }
	
	
	
	
	
	///////////////////////
	
	// https://segmentfault.com/a/1190000003903965
	/**
	 * 和I的思路一样，不过这里我们有K个颜色，不能简单的用Math.min方法了。
	 * 如果遍历一遍颜色数组就找出除了自身外最小的颜色呢？我们只要把最小和次小的都记录下来就行了，
	 * 这样如果和最小的是一个颜色，就加上次小的开销，反之，则加上最小的开销。
	 * */
	public int minCostII(int[][] costs) {
		if(costs != null && costs.length == 0) return 0;
		int len = costs.length;   // house
		int k = costs[0].length;  // color
		
		int preMin = 0;
		int preSecMin = 0;
		int preHouse = 0;
		
		for (int i = 0; i < len; i++) {
			
			int curMin = Integer.MAX_VALUE;
			int curSecMin = Integer.MAX_VALUE;
			int curHouse = -1;
			
			for (int j = 0; j < k; j++) {
				costs[i][j] += (j == preHouse ? preSecMin : preMin);
				if (costs[i][j] <= curMin) {
					curSecMin = curMin;
					curMin = costs[i][j];
					curHouse = j;
				} else if (costs[i][j] < curSecMin) {
					curSecMin = costs[i][j];
				}
			}
			
			preMin = curMin;
			preSecMin = curSecMin;
			preHouse = curHouse;
		}
		return preMin;
    }
}
