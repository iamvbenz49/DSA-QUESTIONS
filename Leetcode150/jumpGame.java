class Solution {
    public boolean canJump(int[] nums) {
        int farthest = nums[0];
        for(int i=1;i<nums.length;i++){
            if(i<=farthest)
                farthest = Math.max(farthest,i+nums[i]);
        }
        return farthest>=nums.length-1;
    }
}
