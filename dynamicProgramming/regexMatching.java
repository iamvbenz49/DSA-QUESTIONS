class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length(), n = s.length();
        Boolean[][] dp = new Boolean[m][n];
        return find(dp, s, p, p.length() - 1, s.length() - 1);
    }
    public boolean find(Boolean[][] dp, String s, String p, int i, int j) {
        if(i < 0 && j < 0) {
            return true;
        }
        if(j < 0 && i >= 0) {
            if(p.charAt(i) == '*'){
                return find(dp, s, p, i - 2 , j);
            } 
            return false;
        }
        if(i < 0 || j < 0) {
            return false;
        }
        if(dp[i][j] != null) 
            return dp[i][j];
        if(p.charAt(i) == s.charAt(j)) {
            return dp[i][j] = find(dp,s, p, i - 1, j - 1);
        } else {
            if(p.charAt(i) == '*') {
                if(p.charAt(i-1) == s.charAt(j) || p.charAt(i-1) == '.'){
                    return dp[i][j] = find(dp, s, p, i, j - 1) || find(dp, s, p, i - 2, j);
                }
                return dp[i][j] = find(dp, s, p, i - 2, j);
            }
            if(p.charAt(i) == '.') {
                return dp[i][j] = find(dp, s, p, i - 1, j - 1);
            }
        }
        return dp[i][j] = false;
    }
}