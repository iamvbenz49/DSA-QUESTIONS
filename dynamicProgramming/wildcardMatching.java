class Solution {
    private int[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new int[s.length()+1][p.length()+1];
        for(int i = 0; i < s.length(); i++) 
            Arrays.fill(dp[i], -1);
        return find(s, p, s.length() - 1, p.length() - 1) == 1;
    }
    public int find(String s, String p, int i, int j) {
        if(i < 0 && j < 0) {
            return 1;
        }
        if(i < 0 && j >= 0) {
            while(j >= 0) {
                if(p.charAt(j) == '*') j--;
                else return 0;
            }
            return 1;
        }
        if(j < 0 && i >= 0) {
            return 0;
        }
        if(dp[i][j]!= -1) {
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = find(s, p, i - 1, j - 1);
        } 
        if(p.charAt(j) == '*') {
            return 
                dp[i][j] = ((find(s, p, i, j - 1) == 1) || (find(s, p, i - 1, j) == 1)) == true?1:0;
        }
        return 0;
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        

        dp[0][0] = true;
        
        // Handle the case where s is empty but p contains '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                
                if (pChar == sChar || pChar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
