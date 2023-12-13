// brute force 


// User function Template for Java

class Solution {
    static long mod = (int)(1e9 + 7);
    long countStrings(int n) {
        long[][] dp = new long[n][2];
        for(long[] arr:dp)
            Arrays.fill(arr,-1);
        return ((count(n,1,0,dp)%mod)+(count(n,1,1,dp)%mod))%mod;
    }
    static long count(int n,int currentLength,int c,long[][] dp){
        if(currentLength==n){
            return 1;
        }
        if(dp[currentLength][c]!=-1)
            return dp[currentLength][c];
        long add0 = count(n,currentLength+1,0,dp); 
        long add1 = 0;
        if(1-c==1){
            add1 = count(n,currentLength+1,1,dp);
        }
        return dp[currentLength][c] = ((add0%mod) + (add1%mod))%mod;
    }
}

// fibonacci style


// TC - O(N) SC - O(N)

class Solution {
    static long mod = (int)(1e9 + 7);
    long countStrings(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return count(n,dp)%mod;
    }
    static long count(int n,long[] dp){
        if(n<=2){
            return n+1;
        }
        if(dp[n]!=-1)return dp[n];
        return dp[n] = ((count(n-1,dp)%mod) + (count(n-2,dp)%mod))%mod;
    }
}
