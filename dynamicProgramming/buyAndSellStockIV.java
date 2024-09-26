class Solution {
    int K;
    public int maxProfit(int k, int[] prices) {
        K = k;
        int m = prices.length;
        int[][][] dp = new int[k][m][2];
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return find(dp, prices, 0, 0, 0);
    }
    public int find(int[][][] dp,int[] prices, int index, int hasHeBought, int k) {
        if(index == prices.length - 1) {
            if(hasHeBought == 1){
                return prices[index];
            }
            return 0;
        }
        if(k == K) {
            return 0;
        }
        if(dp[k][index][hasHeBought] != -1) {
            return dp[k][index][hasHeBought];
        }
        if(hasHeBought == 1) {
            return dp[k][index][hasHeBought] = Math.max(
                prices[index] + find(dp, prices, index + 1, 0, k + 1),
                find(dp, prices, index + 1, 1, k)
            );
        }
        return dp[k][index][hasHeBought] = Math.max(
                -prices[index] + find(dp, prices, index + 1, 1, k),
                find(dp, prices, index + 1, 0, k)
        );
    }
}

class Solution {
    int K;
    public int maxProfit(int k, int[] prices) {
        K = k;
        int m = prices.length;
        int[][][] dp = new int[k+1][m+1][2];
        // for(int i = 0; i < k; i++) {
        //     for(int j = 0; j < m; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        for(; k >= 0; k--) {
            for(int index = m - 1; index >= 0; index--) {
                for(int hasHeBought = 1; hasHeBought >= 0; hasHeBought--) {
                    if(index == prices.length - 1) {
                        if(hasHeBought == 1){
                            dp[k][index][hasHeBought] = prices[index];
                        }
                    }
                    else if(k == K) {
                        
                    } else if(hasHeBought == 1) {
                        System.out.println(k+" "+index+" "+hasHeBought);
                        dp[k][index][hasHeBought] = Math.max(
                            prices[index] + dp[k + 1][index + 1][0],
                            dp[k][index + 1][1]
                        );
                    } else {
                        dp[k][index][hasHeBought] = Math.max(
                            -prices[index] + dp[k][index + 1][1],
                            dp[k][index + 1][0]
                        );
                    }
                }
            }
        }
        return dp[0][0][0];
    }
    public int find(int[][][] dp,int[] prices, int index, int hasHeBought, int k) {
        if(index == prices.length - 1) {
            if(hasHeBought == 1){
                return prices[index];
            }
            return 0;
        }
        if(k == K) {
            return 0;
        }
        if(dp[k][index][hasHeBought] != -1) {
            return dp[k][index][hasHeBought];
        }
        if(hasHeBought == 1) {
            return dp[k][index][hasHeBought] = Math.max(
                prices[index] + find(dp, prices, index + 1, 0, k + 1),
                find(dp, prices, index + 1, 1, k)
            );
        }
        return dp[k][index][hasHeBought] = Math.max(
                -prices[index] + find(dp, prices, index + 1, 1, k),
                find(dp, prices, index + 1, 0, k)
        );
    }
}