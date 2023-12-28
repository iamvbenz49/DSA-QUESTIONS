class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int firstHouse = rob(nums,dp,0,nums.length-1);
        Arrays.fill(dp,-1);
        int secondHouse = rob(nums,dp,1,nums.length);
        return Math.max(firstHouse,secondHouse);
    }
    public int rob(int[] nums,int[] dp,int index,int end){
        if(index>=end)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        int pick = nums[index] + rob(nums,dp,index+2,end);
        int notPick = 0 + rob(nums,dp,index+1,end);
        
        return dp[index] = Math.max(pick,notPick);
    }
}
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        return Math.max(rob(nums,0,1),rob(nums,1,0));
    }
    public int rob(int[] nums,int start,int end) {
        int first = 0, second = 0;
        for(int i = nums.length-1-end;i>=0+start;i--){
            int third = first;
            first = nums[i];
            if(i<nums.length-2)
                first += second;
            second = third;
            first = Math.max(second,first);
        }
        return first;
    }
}
