class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return CP(grid,dp,0,0,grid[0].length-1);
    }
    public int CP(int[][] grid,int[][][] dp,int row,int col1,int col2){
        if(row==grid.length){
            return 0;
        }
        if(col1<0 || col1>=grid[0].length||col2<0||col2>=grid[0].length){
            return -(int)1e8;
        }
        if(dp[row][col1][col2]!=-1)return dp[row][col1][col2];
        int[] direction = {-1,0,1};
        int max = -1;
        for(int x:direction){
            for(int y:direction){
                max = Math.max(max,CP(grid,dp,row+1,col1+x,col2+y));
            }
        }
        if(col1==col2){
            return dp[row][col1][col2] = grid[row][col1] + max;
        }
        return dp[row][col1][col2] = grid[row][col1] + grid[row][col2] + max;
    }
}
