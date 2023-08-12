class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>  mainList = new ArrayList<>();
        combine(1,n,k,mainList,new ArrayList<>());
        return mainList;
    }
    public void combine(int start,int end,int k,List<List<Integer>>  mainList,List<Integer> subList){
        if(subList.size()==k){
            mainList.add(subList);
            return;
        }
        for(int i=start;i<=end;i++){
            subList.add(i);
            combine(i+1,end,k,mainList,new ArrayList<>(subList));
            subList.remove(subList.size()-1);
        }
    }
}
