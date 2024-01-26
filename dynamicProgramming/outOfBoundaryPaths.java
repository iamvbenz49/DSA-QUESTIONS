class Solution {
    private int mod = (int)1e9 + 7;
    private Integer[][][] memo;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new Integer[m][n][maxMove + 1];
        // for(int i)
        return find(m, n, maxMove, startRow, startColumn);
    }
public int find(int m, int n, int maxMoves, int x, int y) {
    if (maxMoves < 0) return 0;
    if (x < 0 || y < 0 || x >= m || y >= n) return 1;

    if (memo[x][y][maxMoves] != null) {
        return memo[x][y][maxMoves];
    }

    int up = find(m, n, maxMoves - 1, x - 1, y) % mod;
    int down = find(m, n, maxMoves - 1, x + 1, y) % mod;
    int left = find(m, n, maxMoves - 1, x, y - 1) % mod;
    int right = find(m, n, maxMoves - 1, x, y + 1) % mod;

    memo[x][y][maxMoves] = ((up + down)%mod + (left + right) % mod)%mod;
    return memo[x][y][maxMoves];
}

}
