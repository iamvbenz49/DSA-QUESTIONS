// TC - O(N) SC - O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int max = -(int)1e7, sum = 0;
        for(int i=0;i<nums.length;i++){
            sum =  sum + nums[i];
            max = Math.max(max,sum);
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }
}
