class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int current = nums[i]-1;
            if(nums[i]!=nums[current]){
                swap(nums,i,current);
            }
            else{
                i++;
            }
        }
       
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int j =0;j<nums.length;j++){
            if(nums[j]!=j+1){
                list.add(nums[j]);
            }
        }
        return list;
    }
    static void swap(int[] nums,int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] =temp;
    }
}
