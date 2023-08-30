class Solution {
    public void solve(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(vis[i][j]==0&&(i==0||i==board.length-1||j==0||j==board[0].length-1)){
                    dfs(vis,board,i,j);
                }
            }
        }
        for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[0].length-1;j++){
                if(vis[i][j]==0&&board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int[][] vis,char[][] board,int row,int col){
        if(row>=0 &&row<board.length&&col>=0&&col<board[0].length&&board[row][col]=='O'&&vis[row][col]==0){
            vis[row][col]=1;
            dfs(vis,board,row-1,col);
            dfs(vis,board,row+1,col);
            dfs(vis,board,row,col-1);
            dfs(vis,board,row,col+1);
        }
    }
}
