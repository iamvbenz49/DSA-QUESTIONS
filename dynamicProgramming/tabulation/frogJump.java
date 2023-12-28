import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            dp[i] = Math.abs(heights[i]-heights[i+1]) + dp[i+1];
            if(i<n-2)
                dp[i] = Math.min(dp[i],Math.abs(heights[i]-heights[i+2]) + dp[i+2]);
        }
        return dp[0];
    }
}
