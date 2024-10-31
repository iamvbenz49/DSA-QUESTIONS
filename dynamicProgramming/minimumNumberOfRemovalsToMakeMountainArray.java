class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n], maxRight = new int[n];
        Arrays.fill(maxLeft, 1);
        Arrays.fill(maxRight, 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    maxLeft[i] = Math.max(maxLeft[i], maxLeft[j] + 1);
                }
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j > i; j--) {
                if(nums[i] > nums[j]) {
                    maxRight[i] = Math.max(maxRight[i], maxRight[j] + 1);
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            if(maxLeft[i] != 1 && maxRight[i] != 1)
                res = Math.max(res, maxRight[i] + maxLeft[i]);
        }
        return nums.length - res + 1;
    }
}