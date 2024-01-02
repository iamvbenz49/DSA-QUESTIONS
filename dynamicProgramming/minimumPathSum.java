

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            Arrays.fill(dp[i],-1);
        return bruteForce(grid,dp,0,0);
    }
    public int bruteForce(int[][] grid,int[][] dp,int row,int col){
        if(row>=grid.length||col>=grid[0].length){
            return 201;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        int goRight = bruteForce(grid,dp,row,col+1);
        int goDown = bruteForce(grid,dp,row+1,col);
        return dp[row][col] = grid[row][col] + Math.min(goRight,goDown);
    }
}
//TC - O(M*N) SC - O(M+N) + O(M*N)
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            Arrays.fill(dp[i],-1);
        return bruteForce(grid,dp,0,0);
    }
    public int bruteForce(int[][] grid,int[][] dp,int row,int col){
        if(row>=grid.length||col>=grid[0].length){
            return 1001;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        int goRight = bruteForce(grid,dp,row,col+1);
        int goDown = bruteForce(grid,dp,row+1,col);
        return dp[row][col] = grid[row][col] + Math.min(goRight,goDown);
    }
}

//TC - O(M*N) SC - O(M*N)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int i=m-2;i>=0;i--){
            dp[i][n-1] = grid[i][n-1] + dp[i+1][n-1];
        }
        for(int i=n-2;i>=0;i--){
            dp[m-1][i] = grid[m-1][i] + dp[m-1][i+1];
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
}

//TC - O(M*N) SC - O(2N)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[n-1] = grid[m-1][n-1]; 
        for(int i=n-2;i>=0;i--){
            dp[i] = dp[i+1] + grid[m-1][i];
        }
        for(int i=m-2;i>=0;i--){
            int[] temp = new int[n];
            temp[n-1] = dp[n-1] + grid[i][n-1];
            for(int j=n-2;j>=0;j--){
                temp[j] = grid[i][j] + Math.min(temp[j+1],dp[j]);
            }
            dp = temp;
        }
        return dp[0];
    }
}
