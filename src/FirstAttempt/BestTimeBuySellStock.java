package FirstAttempt;

public class BestTimeBuySellStock {

	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int res = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
        	int cur = prices[i];
        	min = Math.min(min, cur);
        	res = Math.max(res, cur - min);
        }
        return res;
    }
}
