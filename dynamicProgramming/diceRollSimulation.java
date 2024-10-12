class Solution {
    private static final int MOD = 1_000_000_007;
    private Long[][][] memo; 

    public int dieSimulator(int n, int[] rollMax) {

        memo = new Long[n + 1][6][16]; 
        

        long result = 0;
        for (int i = 0; i < 6; i++) {
            result = (result + dfs(n - 1, i, 1, rollMax)) % MOD; 
        }
        
        return (int) result;
    }

    private long dfs(int n, int last, int count, int[] rollMax) {
        if (n == 0) return 1;

        if (memo[n][last][count] != null) {
            return memo[n][last][count];
        }

        long total = 0;


        for (int i = 0; i < 6; i++) {
            if (i != last) { // Different face
                total = (total + dfs(n - 1, i, 1, rollMax)) % MOD; 
            } else { // Same face
                if (count < rollMax[last]) { 
                    total = (total + dfs(n - 1, last, count + 1, rollMax)) % MOD; 
                }
            }
        }


        memo[n][last][count] = total;
        return total;
    }
}
