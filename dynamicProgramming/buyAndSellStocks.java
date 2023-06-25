class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            minVal = Math.min(prices[i],minVal);
            profit = Math.max(profit,prices[i]-minVal);
        }
        return profit;
    }
}
