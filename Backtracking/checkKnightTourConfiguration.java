class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return find(grid, 0, 0, 0);
    }
    public boolean find(int[][] grid, int row, int col, int index) {
        if(index == (grid.length*grid.length)) {
            return true;
        }
        if(row < 0||row >= grid.length||col < 0||col >= grid.length|| grid[row][col] != index) {
            return false;
        }
        boolean move1 = find(grid, row - 2, col + 1, index + 1);
        boolean move2 = find(grid, row - 2, col - 1, index + 1);
        boolean move3 = find(grid, row + 2, col - 1, index + 1);
        boolean move4 = find(grid, row + 2, col + 1, index + 1);
        boolean move5 = find(grid, row + 1, col + 2, index + 1);
        boolean move6 = find(grid, row + 1, col - 2, index + 1);
        boolean move7 = find(grid, row - 1, col + 2, index + 1);
        boolean move8 = find(grid, row - 1, col - 2, index + 1);

        return move1 || move2 || move3 || move4 || move5 || move6 || move7 || move8;
    }
}
