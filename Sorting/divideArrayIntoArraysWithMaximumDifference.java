class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] res = new int[nums.length/3][3];
        Arrays.sort(nums);
        for(int i=0;i<nums.length/3;i++){
            int idx = 3*i;
            if(Math.abs(nums[idx]-nums[idx+2])<=k && Math.abs(nums[idx]-nums[idx+1])<=k){
                res[i][0] = nums[idx];
                res[i][1] = nums[idx+1];
                res[i][2] = nums[idx+2];
            }else{
                return new int[][]{};
            }
        }
        return res;
    }
}
