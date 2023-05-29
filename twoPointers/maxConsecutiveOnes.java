class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,j=0;
        int res = 0;
        while(j<nums.length){
            if(nums[j]==0){
                i = j+1;
            }
            j++;
            res = Math.max(res,j - i);
        }
        return res;
    }
}
