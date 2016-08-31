package FirstAttempt;

public class BestTimeBuySellStockIV {

	// http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
	public int maxProfit(int k, int[] prices) {
		if (prices.length < 2) return 0;
        
        int days = prices.length;
        if (k >= days) return maxProfit2(prices);
        
        int[][] local = new int[days][k+1];   //local[i][j]: 强制第i天一定交易了，第i天，交易了j次的局部最大收益
        int[][] global = new int[days][k+1];  //global[i][j]: 第i天，交易了j次的全局最大收益
        
        for (int i = 1; i < days; i++) {  // 第一天一定没交易，所以收益为0，不用初始化了。从第二天开始交易
        	int diff = prices[i] - prices[i-1];
        	for (int j = 1; j <= k; j++) { // 交易了k次
        		
        		local[i][j] = Math.max(local[i-1][j]+diff, global[i-1][j-1]);  //diff>0：强制第i天交易了，i-1天和i天的交易合并为一个，local[i-1][j]+diff   
        																	   //diff<0：强制第i天交易了，global[i-1][j-1], i天交易还不如不交易，于是浪费一次机会
        		global[i][j] = Math.max(local[i][j], global[i-1][j]);  // diff>0: 第i天交易了，所以满足local的限定条件：local[i][j]
        															   // diff<0: 第i天没交易，global[i-1][j];
        		
        	}
        }
        return global[days-1][k];
    }
	
	
	// 交易次数大于天数时，相当于第二问，可以每天都交易，相当于可以无限次数交易
	private int maxProfit2(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}
