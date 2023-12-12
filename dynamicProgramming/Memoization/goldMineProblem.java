class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,dfs(n,m,i,0,M,dp));
        }
        return max;
    }
    static int dfs(int n,int m,int row,int col,int M[][],int[][] dp){
        if(row<0||col<0||row>=n||col>=m){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int pathUp = dfs(n,m,row-1,col+1,M,dp);
        int pathRight = dfs(n,m,row,col+1,M,dp);
        int pathDown = dfs(n,m,row+1,col+1,M,dp);
        
        return dp[row][col] = M[row][col] + Math.max(pathUp,Math.max(pathRight,pathDown));
    }
}
