class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();
        int[] vis = new int[nums.length];
        permutations(mainList,new ArrayList<>(),nums,vis);
        return mainList;
    }
    public void permutations(List<List<Integer>> mainList,List<Integer> subList,int[] nums,int[] vis){
        if(subList.size()==nums.length){
            mainList.add(subList);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i]!=1){
                vis[i] = 1;
                subList.add(nums[i]);
                permutations(mainList,new ArrayList<>(subList),nums,vis);
                subList.remove(subList.size()-1);
                vis[i] = 0;
            }
        }
    }
}
