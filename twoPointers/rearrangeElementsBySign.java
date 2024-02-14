class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1, right = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) {
                res[left] = nums[i];
                left += 2;
            }
            else{
                res[right] = nums[i];
                right += 2;
            } 
        }
        return res;
    }
}
