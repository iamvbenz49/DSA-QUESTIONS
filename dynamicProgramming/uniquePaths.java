//recursion
class Solution {
    public int uniquePaths(int m, int n) {
        return unique(m,n,0,0);
    }
    public int unique(int m,int n,int i,int j){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }

        int l = unique(m,n,i+1,j,dp);
        int r = unique(m,n,i,j+1,dp);

        return l+r;
    }
}

//memoisation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return unique(m,n,0,0,dp);
    }
    public int unique(int m,int n,int i,int j,int[][] dp){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }

        int l =  unique(m,n,i+1,j,dp);
        int r =  unique(m,n,i,j+1,dp);

        return dp[i][j] = l+r;
    }
}

//tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

}

//space optimised solution
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp,1);

        for(int i=1;i<m;i++){
            int[] temp = new int[n];
            Arrays.fill(temp,1);
            for(int j=1;j<n;j++){
                temp[j] = dp[j] + temp[j-1];
            }
            dp = temp;
        }

        return dp[n-1];
    }

}
