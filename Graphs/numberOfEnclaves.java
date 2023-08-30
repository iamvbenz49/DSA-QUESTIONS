class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j]==0&&(i==0||i==grid.length-1||j==0||j==grid[0].length-1)){
                    dfs(vis,grid,i,j);
                }
            }
        }
        int count=0;
        for(int i=1;i<grid.length-1;i++){
            for(int j=1;j<grid[0].length-1;j++){
                if(vis[i][j]==0&&grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] vis,int[][] board,int row,int col){
        if(row>=0 &&row<board.length&&col>=0&&col<board[0].length&&board[row][col]==1&&vis[row][col]==0){
            vis[row][col]=1;
            dfs(vis,board,row-1,col);
            dfs(vis,board,row+1,col);
            dfs(vis,board,row,col-1);
            dfs(vis,board,row,col+1);
        }
    }
}
