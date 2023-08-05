class Solution {
    public List<List<Integer>> subsets(int[] nums) {  
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums,temp,list,0);
        return list;
    }
    public void backtrack(int[] nums,List<Integer> temp,List<List<Integer>> res,int start){
        res.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(nums,temp,res,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
