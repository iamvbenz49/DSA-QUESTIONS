//Memoisation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1)return 0;
        int[] dp = new int[n];
        for(int i=n-1;i>=0;i--){
            if(obstacleGrid[m-1][i]==1)break;
            dp[i] = 1;
        }
        boolean endObstacle = false;
        for(int i=m-2;i>=0;i--){
            int[] temp = new int[n];
            if(obstacleGrid[i][n-1]!=1 && !endObstacle){
                temp[n-1] = 1;
            }else{
                endObstacle = true;
            }
            for(int j=n-2;j>=0;j--){
                if(obstacleGrid[i][j]!=1)
                    temp[j] = dp[j] +temp[j+1];
                System.out.print("Inise"+Arrays.toString(temp)+" "+i+" "+j);
            }
            dp = temp;
            System.out.println(Arrays.toString(dp));        }
        return dp[0];
    }
}
//tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=m-1;i>=0;i--){
            if(obstacleGrid[i][n-1]==1)break;
            dp[i][n-1] = 1;
        }
        for(int i=n-1;i>=0;i--){
            if(obstacleGrid[m-1][i]==1)break;
            dp[m-1][i] = 1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(obstacleGrid[i][j]==1)continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }
}
//space optimised tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1)return 0;
        int[] dp = new int[n];
        for(int i=n-1;i>=0;i--){
            if(obstacleGrid[m-1][i]==1)break;
            dp[i] = 1;
        }
        boolean endObstacle = false;
        for(int i=m-2;i>=0;i--){
            int[] temp = new int[n];
            if(obstacleGrid[i][n-1]!=1 && !endObstacle){
                temp[n-1] = 1;
            }else{
                endObstacle = true;
            }
            for(int j=n-2;j>=0;j--){
                if(obstacleGrid[i][j]!=1)
                    temp[j] = dp[j] +temp[j+1];
                System.out.print("Inise"+Arrays.toString(temp)+" "+i+" "+j);
            }
            dp = temp;
            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }
}
