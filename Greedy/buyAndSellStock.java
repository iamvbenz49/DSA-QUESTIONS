class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int profit = 0;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                profit = Math.max(prices[r]-prices[l],profit);
            }
            else{
                l = r;
            }
            r++;
        }
        return profit;
    }
}
