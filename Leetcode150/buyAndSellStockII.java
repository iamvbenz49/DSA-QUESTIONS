class Solution {
    public int maxProfit(int[] prices) {
        return buyAndSell(prices,0,1);
    }
    public int buyAndSell(int[] prices, int index, int buy){
        if(index==prices.length)
            return 0;
        int profit = (int)-1e15;
        if(buy==1){
            profit = Math.max(
                -prices[index] + buyAndSell(prices,index+1,0),
                buyAndSell(prices,index+1,1)
            );
        }else{
            profit = Math.max(
                prices[index] + buyAndSell(prices,index+1,1),
                buyAndSell(prices,index+1,0)
            );
        }
        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return buyAndSell(prices,dp,0,1);
    }
    public int buyAndSell(int[] prices, int[][] dp, int index, int buy){
        if(index==prices.length)
            return 0;
      //  if(dp[])
        int profit = 0;
        if(dp[index][buy]!=-1) return dp[index][buy];
        if(buy==1){
            profit = Math.max(
                -prices[index] + buyAndSell(prices,dp,index+1,0),
                buyAndSell(prices,dp,index+1,1)
            );
        }else{
            profit = Math.max(
                prices[index] + buyAndSell(prices,dp,index+1,1),
                buyAndSell(prices,dp,index+1,0)
            );
        }
        return dp[index][buy] = profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length-1;
        int buy, sell, index = 0, profit = 0;
        while(index<n){
            if(index<n && prices[index+1]<=prices[index]) index++;
            buy = prices[index];
            if(index<n && prices[index+1]>prices[index]) index++;
            sell = prices[index];
            profit = profit + (sell-buy);
        }
        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length-1;
        int buy, sell, index = 0, profit = 0;
        while(index<n){
            while(index<n && prices[index+1]<=prices[index]) index++;
            buy = prices[index];
            while(index<n && prices[index+1]>prices[index]) index++;
            sell = prices[index];
            profit = profit + (sell-buy);
        }
        return profit;
    }
}
