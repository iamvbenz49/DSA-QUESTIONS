//memoisation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return lcs(text1,text2,0,0,dp);
    }
    public int lcs(String tx1,String tx2,int i,int j,Integer[][] dp){
        if(i>=tx1.length() || j>=tx2.length()){
            return 0;
        }
        int l = tx1.charAt(i);
        int r = tx2.charAt(j);
        if(dp[i][j]!=null)
            return dp[i][j];
        if(l==r){
            return dp[i][j] = 1 + lcs(tx1,tx2,i+1,j+1,dp);
        }
        return dp[i][j] = Math.max(
            lcs(tx1,tx2,i+1,j,dp),
            lcs(tx1,tx2,i,j+1,dp)
        );
    }
}
//tabulation

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i =1;i<=text1.length();i++){
            for(int j =1;j<=text2.length();j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(
                        dp[i-1][j],
                        dp[i][j-1]
                    );
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
//space optimised DP

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length()+1];

        for(int i =1;i<text1.length()+1;i++){
            int[] curr = new int[text2.length()+1];
            for(int j =1;j<text2.length()+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    curr[j] = 1 + dp[j-1];
                }
                else{
                    curr[j] = Math.max(
                        curr[j-1],
                        dp[j]
                    );
                }
            }
            dp = curr;
        }
        
        int max = 0;
        for(int i=0;i<text2.length()+1;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
