class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, count = 0, res = 0;
        while(right < nums.length) {
            if(nums[right] == 0) {
                count++;
            }
            while(count > k) {
                if(nums[left] == 0) {
                    count--;
                }
                left++;
            }
       //     System.out.prin
            res = Math.max(right - left + 1, res);
            right++;
        }
        return res;
    }
}