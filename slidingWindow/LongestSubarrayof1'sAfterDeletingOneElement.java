class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zero = -1;
        boolean check = false;
        int max = 0;
        for(right = 0;right<nums.length;right++){
            if(nums[right]==0){
                left = zero+1;
                zero = right;
            }
            max = Math.max(right-left,max);
        }
        return max;
    }
}
