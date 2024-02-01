// Check Peak Index question before this for intuition from neetcode and my solution

class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int left = 0 , right = nums.length - 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid+1]>nums[mid]) left = mid + 1;
            else right = mid;
        } 
        return right;
    }
}
