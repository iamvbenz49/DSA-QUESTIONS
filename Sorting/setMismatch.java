class Solution {
    public int[] findErrorNums(int[] nums) {
        sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]-1) return new int[]{nums[i],i+1};
        }
        return new int[]{};
    }
    public void sort(int[] nums){
        int index = 0;
        while(index<nums.length){
            int element = nums[index] - 1;
            if(nums[index]!=nums[element]) swap(nums,element,index);
            else index++;
        }
    }
    public void swap(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp; 
    }
}
