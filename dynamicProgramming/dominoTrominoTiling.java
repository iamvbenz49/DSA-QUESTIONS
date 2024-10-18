class Solution {
    private int MOD = 1_000_000_007;
    
    public int numTilings(int n) {
        int[][] dp = new int[n+1][n+1];
        // for(int i = 0; i <= n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        dp[0][0] = 1;
        for(int firstRow = 1; firstRow <= n; firstRow++) {
            for(int secondRow = 1; secondRow <= n; secondRow++) {
                int res = 0;
                if(firstRow == secondRow) {
                    res = (res + dp[firstRow - 1][secondRow - 1])%MOD;
                    if(secondRow > 1) res = (res + dp[firstRow - 2][secondRow - 2])%MOD;
                    if(secondRow > 1) res = (res + dp[firstRow - 1][secondRow - 2])%MOD;
                    if(firstRow > 1) res = (res + dp[firstRow - 2][secondRow - 1])%MOD;
                } else if(firstRow > secondRow) {
                    if(firstRow > 1) res = (res + dp[firstRow - 2][secondRow - 1])%MOD; //tromino
                    if(firstRow > 1) res = (res + dp[firstRow - 2][secondRow])%MOD; //domino
                } else {
                    if(secondRow > 1) res = (res + dp[firstRow - 1][secondRow - 2])%MOD; //tromino
                    if(secondRow > 1) res = (res + dp[firstRow][secondRow - 2])%MOD; //domino
                }
                dp[firstRow][secondRow] = res;
            }
        }
        return dp[n][n];
    }
    public int find(int[][] dp, int firstRow, int secondRow) {
        if(firstRow == 0 && secondRow == 0) {
            return 1;
        }
        if(firstRow <= 0 || secondRow <= 0) {
            return 0;
        }
        if(dp[firstRow][secondRow] != -1) {
            return dp[firstRow][secondRow];
        }
        int res = 0;

        if(firstRow == secondRow) {
            res = (res + find(dp, firstRow - 1, secondRow - 1))%MOD;
            res = (res + find(dp, firstRow - 2, secondRow - 2))%MOD;
            res = (res + find(dp, firstRow - 1, secondRow - 2))%MOD;
            res = (res + find(dp, firstRow - 2, secondRow - 1))%MOD;
        } else if(firstRow > secondRow) {
            res = (res + find(dp, firstRow - 2, secondRow - 1))%MOD; //tromino
            res = (res + find(dp, firstRow - 2, secondRow))%MOD; //domino
        } else {
            res = (res + find(dp, firstRow - 1, secondRow - 2))%MOD; //tromino
            res = (res + find(dp, firstRow , secondRow - 2))%MOD; //domino
        }
        return dp[firstRow][secondRow] = res;
    }
}