class Solution {
    public int tallestBillboard(int[] rods) {
        int SIZE = rods.length;
        int[][] dp = new int[SIZE][2*5000 + 1];
        for(int i = 0; i < SIZE; i++) {
            Arrays.fill(dp[i], -1);
        }
        return find(dp, rods, 0, 0);
    }
    public int find(int[][] dp, int[] rods, int index, int diff) {
        if(index == rods.length) {
            if(diff == 0) {
                return 0;
            }
            return -(int)1e9;
        }
        if(dp[index][5000 + diff] != -1) {
            return dp[index][5000 + diff];
        }
        int notTake = find(dp, rods, index + 1, diff);
        int takeFirst = rods[index] + find(dp, rods, index + 1, diff + rods[index]);
        int takeSecond = find(dp, rods, index + 1, diff - rods[index]);

        return dp[index][5000 + diff] = Math.max(
            notTake,
            Math.max(takeFirst, takeSecond)
        );
    }
}