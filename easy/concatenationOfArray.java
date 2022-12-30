class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[2*nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = arr[nums.length+i] = nums[i];
        }
        return arr;
    }
}
