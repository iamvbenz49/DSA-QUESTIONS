class Solution {
    private int MOD = (int)1e9 + 7;
    public int countWinningSequences(String s) {
        int n = s.length();
        int[][][] dp = new int[n + 1][4][2 * n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 4; j++)
                Arrays.fill(dp[i][j], -1);
        }
        return find(dp, s, 0, -1, 0, 0);
    }
    public int find(int[][][] dp, String s, int index, int prevBobMove, int PA, int PB) {
        if(index == s.length()) {
            if(PB > PA) {
                return 1;
            }
            return 0;
        }

        int winDiff = PB - PA + s.length();
        if(dp[index][prevBobMove + 1][winDiff] != -1) {
            return dp[index][prevBobMove + 1][winDiff];
        }
        int result = 0;
        char aliceMove = s.charAt(index);

   
        for (int bobMove = 0; bobMove < 3; bobMove++) {
            if (bobMove == prevBobMove) continue; 

            int newPA = PA, newPB = PB;
            // 0 -fire 1-water 2 -earth
            if (aliceMove == 'F' && bobMove == 1) newPB++; 
            if (aliceMove == 'W' && bobMove == 2) newPB++;
            if (aliceMove == 'E' && bobMove == 0) newPB++;

            if (bobMove == 0 && aliceMove == 'W') newPA++; 
            if (bobMove == 1 && aliceMove == 'E') newPA++; 
            if (bobMove == 2 && aliceMove == 'F') newPA++; 
        
            result = (result + find(dp, s, index + 1, bobMove, newPA, newPB)) % MOD;
        }
        return dp[index][prevBobMove + 1][winDiff] = result;
    }
}