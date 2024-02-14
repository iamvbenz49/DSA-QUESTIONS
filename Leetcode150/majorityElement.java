class Solution {
    public int majorityElement(int[] nums) {
        int number = nums[0], count = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==number) count++;
            else count--;
            if(count==0){
                number = nums[i];
                count = 1;
            }
        }
        return number;
    }
}
