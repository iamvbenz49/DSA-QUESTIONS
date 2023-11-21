class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int right,left,res;
        left = 0;
        right = 0;
        long sum = 0;
        res = 0;
        while(right<nums.length){
            sum += nums[right];
            if(sum+k<(long)(nums[right])*(right-left+1)){
                sum-=nums[left];
                left+=1;
            }
            right+=1;
        }
        return right-left;
    }
}
