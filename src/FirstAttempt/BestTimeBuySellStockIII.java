package FirstAttempt;

public class BestTimeBuySellStockIII {

	// http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
	// limits the number of transactions to 2
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
	 
		int len = prices.length;
		//highest profit in 0 ... i
		int[] left = new int[len];
		int[] right = new int[len];
		
		int min = prices[0];
		left[0] = 0;
		for (int i = 1; i < len; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i-1], prices[i]-min);
		}
		
		int max = prices[len-1];
		right[len-1] = 0;
		for (int i = len-2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(right[i+1], max-prices[i]);
		}
		
		int profit = 0;
		for (int i = 0; i < len; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}
		return profit;
    }
}
