// TC = O(N) SC - 0(N)

class Solution {
    static long mod = (int)(1e9 + 7);
    long countStrings(int n) {
        if(n==1)
            return 2;
        // SC - O(N)
        long[] dp = new long[n+1];
        dp[1] = 2;
        dp[2] = 3;
        // TC - O(N)
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }
        return (dp[n])%mod;
    }
}
