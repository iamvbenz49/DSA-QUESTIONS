

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
//TC - O(M*N) SC - O(M+N) + O(M+N)
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
