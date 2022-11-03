class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        res[0] = search(nums,target,true);
        if(res[0] == -1){
            return res;
        }
        res[1] = search(nums,target,false);
        return res;
    }
    static int search(int[] nums,int target,boolean startindex){
        
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(end>=start){
            int mid = start + (end-start)/2;
            if(target>nums[mid]){
                start = mid+1;
            }
            else if(target<nums[mid]){
                end = mid-1;
            }
            else if(target == nums[mid]){
                ans = mid;
                if(startindex){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return ans;
    }
    
}
