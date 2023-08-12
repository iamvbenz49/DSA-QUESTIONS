class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if(i>start && candidates[i-1]==candidates[i])continue;
            subList.add(candidates[i]);
            combinationSum(candidates,mainList,new ArrayList<>(subList),i+1,target,sum+candidates[i]);
            subList.remove(subList.size()-1);
        }
    }
}
