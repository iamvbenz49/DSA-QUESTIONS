class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length+1][target+2001];
        for(int i=0;i<=nums.length;i++)
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        return findTargetSumWays(nums,dp,target,0);
    }
    public int findTargetSumWays(int[] nums,int[][] dp,int target,int index){
        if(index==nums.length){
            if(target==0)
                return 1;
            else
                return 0;
        }
        if(dp[index][target+1000]!=Integer.MIN_VALUE)
            return dp[index][target+1000];
        int addPositive1 = findTargetSumWays(nums,dp,target+nums[index],index+1);
        int addNegative1 = findTargetSumWays(nums,dp,target-nums[index],index+1);
        return dp[index][target+1000] = addPositive1+addNegative1;
    }
}
