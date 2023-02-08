class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int curr = 0;
        int r =0;
        for(int i=0;i<nums.length-1;i++){
            maxJump = Math.max(maxJump,i+nums[i]);
            if(i==curr){
                r++;
                curr = maxJump;
            }
        }
        return r;
    }
}
