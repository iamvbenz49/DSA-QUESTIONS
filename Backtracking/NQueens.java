class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resBoard = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(n,board,0,resBoard);
        return resBoard;
    }
    public void backtrack(int n,char[][] board,int row,List<List<String>> resBoard){
        if(board.length==row){
            construct(board,resBoard);
        }
        for(int col=0;col<n;col++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                backtrack(n,board,row+1,resBoard);
                board[row][col] = '.';
            }
        }
    }
    public void construct(char[][] board,List<List<String>> resBoard){
        List<String> subBoard = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String res = "";
            for(int j=0;j<board.length;j++){
                res+=board[i][j];
            }
            subBoard.add(res);
        }
        resBoard.add(subBoard);
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
