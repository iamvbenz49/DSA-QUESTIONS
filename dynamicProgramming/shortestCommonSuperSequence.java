class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int M = str1.length(), N = str2.length();
        int[][] dp = new int[M + 1][N + 1];

        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }
        int i = M, j = N;
        String res = "";
        while(i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res = res + str1.charAt(i - 1);
                i--;
                j--;
            } else if(dp[i - 1][j] < dp[i][j - 1]) {
                res = res + str2.charAt(j - 1);
                j--;
            } else {
                res = res + str1.charAt(i - 1);
                i--;
            }
        }

        while(i > 0) {
            res = res + str1.charAt(i - 1);
            i--;
        }

        while(j > 0) {
            res = res + str2.charAt(j - 1);
            j--;
        }
        return new StringBuilder(res).reverse().toString();
    }
}