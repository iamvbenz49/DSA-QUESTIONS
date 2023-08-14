class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        return backtrack(n,board,0); 
    }
    public int backtrack(int n,char[][] board,int row){
        if(board.length==row){
            return 1;
        }
        int sum = 0;
        for(int col=0;col<n;col++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                sum += backtrack(n,board,row+1);
                board[row][col] = '.';
            }
        }
        return sum;
    }
    public boolean isSafe(int row,int col,char[][] board){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=1;row-i>=0&&col+i<board.length;i++){
            if(board[row-i][col+i]=='Q'){
                return false;
            }
        }
        for(int i=1;row-i>=0&&col-i>=0;i++){
            if(board[row-i][col-i]=='Q'){
                return false;
            }
        }
        return true;
    }
}
