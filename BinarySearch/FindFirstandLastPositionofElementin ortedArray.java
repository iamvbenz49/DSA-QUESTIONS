class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                start = mid;
                end = mid;
                while(start!=-1 && nums[start]==target)
                    start--;
                while(end!=nums.length && nums[end]==target)
                    end++;
                return new int[]{start+1,end-1};
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}
