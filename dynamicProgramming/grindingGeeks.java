// Recursion TLE
class Solution {
    public int max_courses(int n, int total, int[] cost) {
        // code here
        return find_max(total,cost,0);
    }
    public int find_max(int money,int[] cost, int index){
        if(index==cost.length || money<=0){
            return 0;
        }
        int pick = 0;
        if(cost[index]<=money){
            int spent = money-cost[index];
            spent += cost[index]*0.9;
            pick = 1 + find_max(spent,cost,index+1);
        }
        int notPick = 0 + find_max(money,cost,index+1);
        return Math.max(pick,notPick);
    }
}

// Memoisation


//User function Template for Java
class Solution {
    public int max_courses(int n, int total, int[] cost) {
        // code here
        int[][] dp = new int[total+1][n];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        return find_max(total,cost,dp,0);
    }
    public int find_max(int money,int[] cost,int[][] dp, int index){
        if(index==cost.length || money<=0){
            return 0;
        }
        int pick = 0;
        if(dp[money][index]!=-1)
            return dp[money][index];
        if(cost[index]<=money){
            int spent = money-cost[index];
            spent += cost[index]*0.9;
            pick = 1 + find_max(spent,cost,dp,index+1);
        }
        int notPick = 0 + find_max(money,cost,dp,index+1);
        return dp[money][index] = Math.max(pick,notPick);
    }
}
