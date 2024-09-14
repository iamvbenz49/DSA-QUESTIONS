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