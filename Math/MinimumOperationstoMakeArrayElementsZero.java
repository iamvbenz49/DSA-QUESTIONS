class Solution {
    public long minOperations(int[][] queries) {
        // create a step function
        // find number of operations needed for each base
        // [1, 3] -> 1
        // [4, 15] -> 2
        // [16, 63] -> 3 
        // then multiply with the number of operations in that range
        long res = 0;
        for(int i = 0; i < queries.length; i++) {
            res += (stepSum(queries[i][1]) - stepSum(queries[i][0] - 1) + 1)/2;
        }
        return res;
    }
    public long stepSum(int n) {
        long base = 1, step = 1, count = 0;

        while(base <= n) {
            long ops = Math.min(base * 4 - 1, n) - base + 1;

            count += step * ops;
            base = base * 4;
            step++;
        }
        return count;
    }
}
