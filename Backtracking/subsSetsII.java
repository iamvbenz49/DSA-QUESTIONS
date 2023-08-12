class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums,list,new ArrayList<>(),0);
        return list;
    }
 
    public void backtrack(int[] nums,List<List<Integer>> list,List<Integer> tempList,int start){
        list.add(tempList);

        for(int i=start;i<nums.length;i++){
            if(i!=start && nums[i]==nums[i-1])continue;
            tempList.add(nums[i]);
            backtrack(nums,list,new ArrayList<>(tempList),i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
