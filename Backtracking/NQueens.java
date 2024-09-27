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

// Baxktracking + Bitmask
class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        // col diagonal antidiagonal
        backtrack(n, board, 0, 0, 0, 0);
        return res;
    }
    
    public void backtrack(int n, boolean[][] board, int row, int column, int diagonal, int antiDiagonal) {
        if(row == board.length) {
            res.add(toBoard(board));
            return;
        }
        for(int i = 0; i < board.length; i++) {
            int columnCheck = column & (1<<i);
            int diagonalCheck = diagonal & (1<<(row+i));
            int antiDiagonalCheck = antiDiagonal & (1<<(row-i+n));
            if(columnCheck != 0 || diagonalCheck != 0 || antiDiagonalCheck != 0) continue;
            column = column | (1<<i);
            diagonal = diagonal | (1<<(row+i));
            antiDiagonal = antiDiagonal | (1<<(row-i+n));
            board[row][i] = true;
            backtrack(n, board, row + 1, column, diagonal, antiDiagonal);
            board[row][i] = false;
            column = column ^ (1<<i);
            diagonal = diagonal ^ (1<<(row+i));
            antiDiagonal = antiDiagonal ^ (1<<(row-i+n));
            
        }
    }
    public List<String> toBoard(boolean[][] board) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board.length; j++) {
                if(board[i][j]) {
                    sb.append('Q');
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}