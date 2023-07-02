class Solution {
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;
        int ans = nums[0];
        for(int i=0;i<nums.length;i++){
            left*=nums[i];
            right*=nums[nums.length-1-i];
            ans = Math.max(ans,Math.max(left,right));
        }
        return ans;
    }
}
