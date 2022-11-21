class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid+1]<nums[mid]){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
}
