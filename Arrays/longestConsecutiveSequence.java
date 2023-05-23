class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int c = 1;
        int max = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                c++;
            }
            else if(nums[i]!=nums[i-1]){
                c =1;
            }
            max = Math.max(c,max);
        }
        return Math.max(c,max);
    }
}
