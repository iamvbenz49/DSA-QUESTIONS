class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> mainList = new ArrayList<>();
        combinationSum(candidates,mainList,new ArrayList<>(),0,target,0);
        return mainList;
    }
    public void combinationSum(int[] candidates,List<List<Integer>> mainList,List<Integer> subList,int start,int target,int sum){
        if(sum==target){
            mainList.add(subList);
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            subList.add(candidates[i]);
            combinationSum(candidates,mainList,new ArrayList<>(subList),i,target,sum+candidates[i]);
            subList.remove(subList.size()-1);
        }
    }
}
