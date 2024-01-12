// TLE Recursion

import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here.
        return bruteForce(num,tar,0);
    }
    public static int bruteForce(int[] num,int target,int index){
        if(target==0)
            return 1;
        if(target<0||index>=num.length)
            return 0;
        int pick = bruteForce(num,target-num[index],index+1);
        int notPick = bruteForce(num,target,index+1);
        return pick + notPick;
    }
}
// Memoization

import java.util.*;
import java.io.*;

public class Solution {
    static int mod = (int)1e9 + 7;
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int[][] dp = new int[num.length+1][tar+1];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        return memo(num,dp,tar,0);
    }
    public static int memo(int[] num,int[][] dp,int target,int index){
        if(target==0)
            return 1;
        if(target<0||index>=num.length)
            return 0;
        if(dp[index][target]!=-1)
            return dp[index][target];
        int pick = memo(num,dp,target-num[index],index+1);
        int notPick = memo(num,dp,target,index+1);
        return dp[index][target] = (pick + notPick)%mod;
    }
}

//Tabulation
import java.util.*;
import java.io.*;

public class Solution {
    static int mod = (int)1e9 + 7;
    public static int findWays(int num[], int target) {
        // Write your code here.
        int[][] dp = new int[target+1][num.length+1];
        for(int i=0;i<=num.length;i++)
            dp[target][i] = 1;
        for(int i=target-1;i>=0;i--){
            for(int j=num.length-1;j>=0;j--){
                int notTake = dp[i][j+1];
                int take = 0;
                if(num[j]+i<=target)
                    take = dp[num[j]+i][j+1];
                dp[i][j] = (take + notTake)%mod;
            }
        }
      //  System.out.print(Arrays.deepToString(dp));
        return dp[0][0];
    }
    
}
