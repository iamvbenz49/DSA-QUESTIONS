class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[W+1][n];
         for(int[] arr:dp)
            Arrays.fill(arr,-1);
         return ks(dp,wt,val,W,0);
    } 
    public static int ks(int[][] dp, int[] wt,int[] val,int weight,int index){
        if(index>=wt.length) return 0;
        if(dp[weight][index]!=-1) return dp[weight][index];
        int notPick = 0 + ks(dp,wt,val,weight,index+1);
        int pick = 0;
        if(wt[index]<=weight){
            pick = val[index] + ks(dp,wt,val,weight-wt[index],index+1);
        }
        return dp[weight][index] = Math.max(pick ,notPick);
    }
}
