//recursive DP
class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        return climb(n,dp);
    }
    public int climb(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        return dp[n] = climb(n-1,dp) + climb(n-2,dp);
    }
}
//iterative dp
class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
//space optimised dp
class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int f = 1;
        int s = 2;
        for(int i=3;i<=n;i++){
            int t = s+f;
            f = s;
            s = t;
        }
        return s;
    }
}
