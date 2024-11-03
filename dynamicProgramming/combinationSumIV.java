class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // Arrays.fill(dp, -1);
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0)
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
    public int find(int[] dp, int[] nums, int target) {
        if(target == 0) {
            return 1;
        }
        if(target < 0) {
            return 0;
        }
        if(dp[target] != -1) return dp[target];
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += find(dp, nums, target - nums[i]);
        }
        return dp[target] = res;
    }
}