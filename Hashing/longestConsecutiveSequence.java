class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums)
            set.add(i);

        int maxLen = 0;
        for(int i=0;!set.isEmpty()||i<nums.length;i++){
            int left = nums[i]-1;
            int right = nums[i]+1;
            set.remove(nums[i]);
            while(set.remove(left))
                left--;
            while(set.remove(right))
                right++;
            
            maxLen = Math.max(maxLen,right-left-1);
        }
        return maxLen;
    }
}
