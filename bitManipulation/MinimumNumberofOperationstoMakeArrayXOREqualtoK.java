class Solution {
    public int minOperations(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            k ^= nums[i];
        }
        return Integer.bitCount(k);
    }
}
