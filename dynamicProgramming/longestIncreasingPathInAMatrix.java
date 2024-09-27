class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, find(dp, matrix, i, j, -1));
            }
        }
        return res;
    }
    public int find(int[][] dp, int[][] matrix, int row, int col, int prev) {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == -1) {
            return 0;
        }
        if(prev >= matrix[row][col]) {
            return 0;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        int currentValue = matrix[row][col];
        matrix[row][col] = -1;
        int up = find(dp, matrix, row - 1, col, currentValue);
        int down = find(dp, matrix, row + 1, col, currentValue);
        int left = find(dp, matrix, row, col - 1, currentValue);
        int right = find(dp, matrix, row , col + 1, currentValue);
        matrix[row][col] = currentValue;
        return dp[row][col] = Math.max(
            Math.max(up, down),
            Math.max(left, right)
        ) + 1;
    }
}