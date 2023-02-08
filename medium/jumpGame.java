class Solution {
    public boolean canJump(int[] nums) {
        //max jump from current index
        int maxJump = 0;

        //run through the array
        for(int i=0;i<nums.length;i++){
            //how far he can go from current index
            int howFar = nums[i]+i;
            //if current index is greater than maximum  
            //jumps he can take,it means he can't reach 
            //the ith or current index return false
            if(i>maxJump){
                return false;
            }
            //else store the maxJump from the current 
            //point
            maxJump = Math.max(maxJump,howFar);
        }
        return true;
    }
}
