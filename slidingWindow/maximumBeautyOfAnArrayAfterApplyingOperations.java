class Solution {
    // youtube reference - https://www.youtube.com/watch?v=N5keVg37R8k
    
    public int maximumBeauty(int[] nums, int k) {
        // Can solve it using line sweep but space constraint occurs
        // for this sliding window approach we are using the difference between two index as key which should be <= 2*k
        int SIZE = nums.length, res  = 1;
        Arrays.sort(nums);
        int left = 0, right = 1;
        while(left < SIZE && right < SIZE) {
            if(nums[right] - nums[left] <= 2*k) 
                res = Math.max(res, right - left + 1);
            else
                left++;
            right++;
        }
        return res;
    }
    public int findCeil(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
    
            if(nums[mid] < target) {
                left = mid + 1;
                ans = left;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}