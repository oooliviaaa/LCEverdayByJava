package FirstAttempt;

public class BestTimeBuySellStockWithCooldown {

	/**
	 * 引入辅助数组sells和buys
	 * sells[i]表示在第i天不持有股票所能获得的最大累计收益 (i天只要不持有就行，可以是在i天前任意一天卖掉的)
	 * buys[i]表示在第i天持有股票所能获得的最大累计收益 (i天持有股票就行，可以是i天前任意一天买的)
	 * 
	 * 初始化数组：
	 * sells[0] = 0
	 * sells[1] = max(0, prices[1] - prices[0])
	 * buys[0] = -prices[0]
	 * buys[1] = max(-prices[0], -prices[1])
	 * 
	 * 状态转移方程：
	 * sells[i] = max(sells[i - 1], buys[i - 1] + prices[i])
	 * buys[i] = max(buys[i - 1], sells[i - 2] - prices[i])
	 * 所求最大收益为sells[n-1]
	 * 
	 * 
	 * http://buttercola.blogspot.com/2016/01/leetcode-best-time-to-buy-and-sell.html
	 * 
	 * To represent the decision at index i:
	 * buy[i]: Max profit till index i. The series of transaction is ending with a buy.
	 * sell[i]: Max profit till index i. The series of transaction is ending with a sell.
	 * 
	 * To clarify:
	 * Till index i, the buy / sell action must happen and must be the last action. 
	 * It may not happen at index i. It may happen at i - 1, i - 2, ... 0.
	 * In the end n - 1, return sell[n - 1]. 
	 * Apparently we cannot finally end up with a buy. In that case, we would rather take a rest at n - 1.
	 * For special case no transaction at all, classify it as sell[i], 
	 * so that in the end, we can still return sell[n - 1].
	 * 
	 * buy[i]: To make a decision whether to buy at i, 
	 * we either take a rest, by just using the old decision at i - 1, 
	 * or sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy at i, because of cooldown.
	 * 
	 * sell[i]: To make a decision whether to sell at i, 
	 * we either take a rest, by just using the old decision at i - 1, 
	 * or buy at/before i - 1, then sell at i.
	 * 
	 * */
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;
		int n = prices.length;
        
        int[] sell = new int[n];
        sell[0] = 0;
        sell[1] = Math.max(prices[1] - prices[0], 0);
        
        int[] buy = new int[n];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        
        for (int i = 2; i < n; i++) {
        	int price = prices[i];
        	sell[i] = Math.max(sell[i-1], buy[i-1] + price);   // 此处加上的不是差价，因为算buy[x]的时候已经从收益中刨出去卖股票花的钱了。
        	buy[i] = Math.max(buy[i-1], sell[i-2] - price);
        }
        return sell[n-1];
    }
	
	
	
	
	
	
	/////////////////////
	// optimized --> 因为状态i只与状态i-1, i-2有关，所以只需保存两个之前的状态即可
	/**
	 * DP solution only depending on i - 1 and i - 2 can be optimized using O(1) space.
	 * Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
	 * Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]
	 * Then arrays turn into Fibonacci like recursion:
	 * b0 = Math.max(b1, s2 - prices[i]);
	 * s0 = Math.max(s1, b1 + prices[i]);
	 * */
	public int maxProfit_opt(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
         
        int b1 = -prices[0];
         
        int s2 = 0;
        int s1 = 0;
         
        for (int i = 1; i <= prices.length; i++) {
            int b0 = Math.max(b1, s2 - prices[i - 1]);
            int s0 = Math.max(s1, b1 + prices[i - 1]);
             
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
         
        return s1;
    }
}
