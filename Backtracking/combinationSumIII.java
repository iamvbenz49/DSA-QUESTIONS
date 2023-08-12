class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> mainList = new ArrayList<>();
        combinationSum(1,n,k,0,new ArrayList<>(),mainList);
        return mainList;
    }
    public void combinationSum(int start,int n,int k,int sum,List<Integer> subList,List<List<Integer>> mainList){
        if(sum>=n && subList.size()>=k){
            if(sum==n && subList.size()==k){
                mainList.add(subList);
            }
            return;
        }
        for(int i=start;i<=9;i++){
            subList.add(i);
            combinationSum(i+1,n,k,sum+i,new ArrayList<>(subList),mainList);
            subList.remove(subList.size()-1);
        }
    }
}
