//memoisation
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];
        return minimumTotal(triangle,0,0,dp);
    }
    public int minimumTotal(List<List<Integer>> triangle,int i,int j,Integer[][] dp){
        int curr = triangle.get(i).get(j);
        if(i==triangle.size()-1)
            return curr;
        if(dp[i][j]!=null)
            return dp[i][j];
        return dp[i][j] = curr + Math.min(minimumTotal(triangle,i+1,j,dp),minimumTotal(triangle,i+1,j+1,dp));
    }
}
//tabulation
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.size()];

        for(int i=0;i<triangle.size();i++)
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);

        for(int i=triangle.size()-2;i>=0;i--){
            for(int j =0;j<triangle.get(i).size();j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
//space optimised
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[] dp = new Integer[triangle.size()];

        for(int i=0;i<triangle.size();i++)
            dp[i] = triangle.get(triangle.size()-1).get(i);

        for(int i=triangle.size()-2;i>=0;i--){
            Integer[] curr = new Integer[triangle.get(i).size()];
            for(int j =0;j<triangle.get(i).size();j++){
                curr[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
            }
            dp = curr;
        }
        return dp[0];
    }
}
