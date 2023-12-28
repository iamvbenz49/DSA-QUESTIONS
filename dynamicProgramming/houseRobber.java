class Solution {
    public int rob(int[] nums) {
        return bruteRob(nums,0);
    }
    public int bruteRob(int[] nums,int index){
        if(index>=nums.length)
            return 0;
        int pick = nums[index] + bruteRob(nums,index+2);
        int notPick = bruteRob(nums,index+1);
        return Math.max(pick,notPick);
    }
}
