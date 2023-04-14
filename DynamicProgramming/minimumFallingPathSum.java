//memoisation
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix.length];
        int min = Integer.MAX_VALUE;
        for(int i =0;i<matrix.length;i++){
            min = Math.min(min,pathSum(matrix,0,i,dp));
        }
        return min;
    }
    public int pathSum(int[][] matrix,int i,int j,Integer[][] dp){
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(j==0){
            return matrix[i][j] + Math.min(
                pathSum(matrix,i+1,j,dp),
                pathSum(matrix,i+1,j+1,dp)
            );
        }
        if(j==matrix[0].length-1){
            return matrix[i][j] + Math.min(
                pathSum(matrix,i+1,j,dp),
                pathSum(matrix,i+1,j-1,dp)
            );
        }

        int l = pathSum(matrix,i+1,j-1,dp);
        int m = pathSum(matrix,i+1,j,dp);
        int r = pathSum(matrix,i+1,j+1,dp);

        return dp[i][j] = matrix[i][j] + Math.min(Math.min(l,m),r);
    }
}
//tabulation
class Solution {
    public int minFallingPathSum(int[][] matrix) {
    
        for(int i =1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                else if(j==matrix[0].length-1){
                    matrix[i][j] +=  Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                else{
                    matrix[i][j] += Math.min( Math.min(matrix[i-1][j-1],matrix[i-1][j+1]),matrix[i-1][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            min = Math.min(min,matrix[matrix.length-1][i]);
        }
        return min;

    }

}
//space optimised
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[] dp = matrix[0];
        for(int i =1;i<matrix.length;i++){
            int[] curr = new int[matrix[0].length];
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    curr[j] = matrix[i][j] + Math.min(dp[j],dp[j+1]);
                }
                else if(j==matrix[0].length-1){
                    curr[j] = matrix[i][j] +  Math.min(dp[j],dp[j-1]);
                }
                else{
                    curr[j] = matrix[i][j] + Math.min( Math.min(dp[j-1],dp[j+1]),dp[j]);
                }
            }
            dp = curr;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<dp.length;i++){
            min = Math.min(min,dp[i]);
        }
        return min;

    }

}
