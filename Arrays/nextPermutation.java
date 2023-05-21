class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i-=1;
        }
        while(i<0){
            Arrays.sort(nums);
            return;
        }
        int j = nums.length-1;
        while(nums[j]<=nums[i]){
            j-=1;
        }
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
        i = i+1;
        j = nums.length-1;
        while(i<j){
            swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
            i+=1;
            j-=1;
        }
    }
}
