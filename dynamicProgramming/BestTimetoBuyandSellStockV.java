class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        Long[][][] dp = new Long[n][k + 1][3]; 

        return dfs(0, k, 0, prices, dp);
    }
    private long dfs(int idx, int kLeft, int holding, int[] prices, Long[][][] dp) {
        if (dp[idx][kLeft][holding] != null) return dp[idx][kLeft][holding];
        if (kLeft == 0) {
            return 0;
        } 
        if(idx == prices.length - 1) {
            if(holding == 1)
                return prices[idx];
            else if(holding == 2)
                return -prices[idx];
            return 0;
        }
        
        

        long max =  dfs(idx + 1, kLeft, holding, prices, dp);

        if (holding == 0) {
            max = Math.max(max, -prices[idx] + dfs(idx + 1, kLeft, 1, prices, dp)); 
            max = Math.max(max, prices[idx] + dfs(idx + 1, kLeft, 2, prices, dp)); 
        } 
        else if(holding == 1){ 
            max = Math.max(max, prices[idx] + dfs(idx + 1, kLeft - 1, 0, prices, dp)); 
        }
        else {
            max = Math.max(max, -prices[idx] + dfs(idx + 1, kLeft - 1, 0, prices, dp)); 
        }

        return dp[idx][kLeft][holding] = max;
    }
}
