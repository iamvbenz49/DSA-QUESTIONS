class Solution {
    public int maximumCount(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]<=0){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        int p = start;
        start = 0;
        end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]>=0){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        int n = end;
        return Math.max(nums.length-p,n+1);
    }
}
