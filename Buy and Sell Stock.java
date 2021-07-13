Stock Trading 1 - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public int maxProfit(int[] prices) 
    {
        if(prices  == null || prices.length <= 1)
            return 0;
        
        int buy = prices[0];        
        int profit = 0;        
        for(int i = 1 ; i < prices.length; i++)
        {
            profit = Math.max(profit, prices[i] - buy);            
            buy = Math.min(buy, prices[i]);
        }
        
        return profit;
    }

************************************************************************************************************************************

Stock Trading II - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 public int maxProfit(int[] prices)
    {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) 
        {
            if (prices[i] > prices[i - 1])
            {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        
        return maxprofit;
    }

************************************************************************************************************************************

Stock Trading III/IV - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
Explanation - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution
public int maxProfit(int k, int[] prices)
    {
		if(prices.length < 2)
		{
			return 0;
		}
		
		int n = prices.length;
		if(k >= n/2)
		{
			int max = 0;
			for(int i = 1; i < n; i++)
			{
				if(prices[i] > prices[i - 1])
				{
					max+=(prices[i] - prices[i - 1]);
				}
			}
			
			return max;
		}
		else
		{
			int[] dp = new int[k + 1][n];
			for(int trans = 1; trans <= k; trans++)
			{
				int localMax =  dp[trans - 1][0] - prices[0];
				for(int day = 1; day < n; day++)
				{
					dp[trans][day] = Math.max(dp[trans][day - 1], prices[day] + localMax);
					localMax = Math.max(localMax, dp[trans - 1][day] - prices[day];
				}
			}		
			
			return dp[k][n - 1];			
		}
      
    }

************************************************************************************************************************************
309. Best Time to Buy and Sell Stock with Cooldown - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) 
        {
            return 0;
        }
        
        int profit1 = 0, profit2 = 0;   
        for(int i = 1; i < prices.length; i++)
        {
            int copy = profit1;
            profit1 = Math.max(profit1 + prices[i] - prices[i - 1, profit2);
            profit2 = Math.max(copy, profit2);
        }
        
        return Math.max(profit1, profit2);
    }

************************************************************************************************************************************
714. Best Time to Buy and Sell Stock with Transaction Fee - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
  public int maxProfit(int[] prices, int fee) 
     {
        int profit = 0;  //No profit initially
        int stockPosition = -prices[0]; // I bought stock with price on day 0
        for (int i = 1; i < prices.length; i++)
        {
            profit = Math.max(profit, stockPosition + prices[i] - fee); // Max of I did No transaction or I sold at today's price and incurred fee
            stockPosition = Math.max(stockPosition, profit - prices[i]); // I just held my stock or I bought from my profit so far
        }
         
        return profit;
    }