class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return find(dp, s, t, 0, 0);
    }
    public int find(int[][] dp, String s, String t, int i, int j) {
        if(j == t.length()) {
            return 1;
        }
        if(i == s.length()) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = find(dp, s, t, i + 1, j + 1)  + find(dp, s, t, i + 1, j); 
        }
        return  dp[i][j] = find(dp, s, t, i + 1, j);
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        // for(int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        for(int i = m; i >= 0; i--) {
            for(int j = n; j >= 0; j--) {
                if(j == n) {
                    dp[i][j] = 1;
                } else if(i == m) {
                    
                } else if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1]  + dp[i + 1][j]; 
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
    public int find(int[][] dp, String s, String t, int i, int j) {
        if(j == t.length()) {
            return 1;
        }
        if(i == s.length()) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = find(dp, s, t, i + 1, j + 1)  + find(dp, s, t, i + 1, j); 
        }
        return  dp[i][j] = find(dp, s, t, i + 1, j);
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n+1];
        // for(int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        
        for(int i = m; i >= 0; i--) {
            int[] temp = new int[n+1];
            for(int j = n; j >= 0; j--) {
                if(j == n) {
                    temp[j] = 1;
                } else if(i == m) {
                    
                } else if(s.charAt(i) == t.charAt(j)) {
                    temp[j] = dp[j + 1]  + dp[j]; 
                } else {
                    temp[j] = dp[j];
                }
            }
            dp = temp;
        }
        return dp[0];
    }
    public int find(int[][] dp, String s, String t, int i, int j) {
        if(j == t.length()) {
            return 1;
        }
        if(i == s.length()) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = find(dp, s, t, i + 1, j + 1)  + find(dp, s, t, i + 1, j); 
        }
        return  dp[i][j] = find(dp, s, t, i + 1, j);
    }
}