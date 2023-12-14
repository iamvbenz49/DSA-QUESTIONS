class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[grid.length], col = new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int[][] diff = new int[m][n];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                diff[i][j] = row[i] + col[j] - (m-row[i]) - (n-col[j]);
            }
        }
        return diff;
    }
}
