class Solution {
    public int maxProduct(int[] nums) {
        int first = nums[0], second = -1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>first){
                second = first;
                first = nums[i];
            }else if(nums[i]>second){
                second = nums[i];
            }
        }
        return (first-1)*(second-1);
    }
}
