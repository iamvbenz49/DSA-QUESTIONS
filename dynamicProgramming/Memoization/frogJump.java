import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return memo(n, dp,heights, 0);
    }
    public static int memo(int n,int[] dp,int[] heights,int step){
        if(step>=heights.length-1)
            return 0;
        if(dp[step]!=-1)
            return dp[step];
        int moveTwoStep = Integer.MAX_VALUE;
        int moveOneStep = Math.abs(heights[step]-heights[step+1]) + memo(n,dp, heights, step+1);
        if(step+2<n)
            moveTwoStep = Math.abs(heights[step]-heights[step+2]) + memo(n,dp, heights, step+2);
        return dp[step] = Math.min(moveOneStep,moveTwoStep);
    }
}
