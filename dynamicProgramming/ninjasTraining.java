//recursion
import java.util.Arrays;

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][3];
        Arrays.fill(dp,-1);
        return training(points,n-1,3,dp);
    }
    public static int training(int[][] points,int day,int last,int[][] dp){
        if(day==0){
            int max = 0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max = Math.max(max, points[day][i]);
                }
            }
            return max;
        }
        if(dp[day][last]!=-1)
            return dp[day][last];
        int max = 0;
        for(int i=0;i<3;i++){
            if(i!=last){
                max =  + Math.max(max,points[day][i]+training(points,day-1,i,dp));
            }
        }
        return dp[day][last] = max;
    }

}
//memoisation
import java.util.Arrays;

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][3];
        for(int i=0;i<points.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return training(points,n-1,3,dp);
    }
    public static int training(int[][] points,int day,int last,int[][] dp){
        if(day==0){
            int max = 0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max = Math.max(max, points[day][i]);
                }
            }
            return max;
        }
        if(last!=3 && dp[day][last]!=-1)
            return dp[day][last];
        int max = 0;
        for(int i=0;i<3;i++){
            if(i!=last){
                max =  + Math.max(max,points[day][i]+training(points,day-1,i,dp));
            }
        }
        return last!=3?dp[day][last] = max:max;
    }

}
//tabulation
import java.util.Arrays;

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                int max = 0;
                for(int k=0;k<3;k++){
                    if(j!=k){
                        max = Math.max(max,points[i-1][k]);
                    }
                }
                points[i][j]+=max;
            }
        }
        int max = 0;
        for(int i=0;i<3;i++){
            max = Math.max(max,points[n-1][i]);
        }
        return max;
    }

}
//space optimised
import java.util.Arrays;

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                int max = 0;
                for(int k=0;k<3;k++){
                    if(j!=k){
                        max = Math.max(max,points[i-1][k]);
                    }
                }
                points[i][j]+=max;
            }
        }
        int max = 0;
        for(int i=0;i<3;i++){
            max = Math.max(max,points[n-1][i]);
        }
        return max;
    }

}
