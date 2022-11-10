class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int current = nums[i]-1;
            if(nums[i]>0 && nums[i]<nums.length && nums[i]!=nums[current]){
                swap(nums,i,current);
            }
            else{
                i++;
            }
        }
       
        int k =0;
        int l = 1;
        while(k<nums.length){
            if(l<nums[k]){
               return l;
            }
            else if(l>nums[k]){
                k++;
            }
            else{
                k++;
                l++;
            }
        }
        return l;
    }
    static void swap(int[] nums,int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] =temp;
    }
}
