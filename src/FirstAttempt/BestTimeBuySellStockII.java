package FirstAttempt;

public class BestTimeBuySellStockII {

	// http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-ii-java/
	// you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	public int maxProfit(int[] prices) {
		int profit = 0;
	    for(int i=1; i<prices.length; i++){
	        int diff = prices[i]-prices[i-1];
	        if(diff > 0){
	            profit += diff;
	        }
	    }
	    return profit;
    }
}
