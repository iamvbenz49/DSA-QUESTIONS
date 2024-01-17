class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> mainList= new ArrayList<>();
        permutations(mainList,new ArrayList<>(),nums,new int[nums.length]);
        return mainList;
    }
    public void permutations(List<List<Integer>> mainList,List<Integer> subList,int[] nums,int[] vis){
        if(subList.size()==nums.length){
            mainList.add(subList);
            return;
        }     
        for(int i=0;i<nums.length;i++){
            if(vis[i]!=1 && i>0 && vis[i-1]!=1 && nums[i-1]==nums[i]){
                continue;
            }
            if(vis[i]==1){
                continue;
            }
            vis[i] = 1;
            subList.add(nums[i]);
            permutations(mainList,new ArrayList<>(subList),nums,vis);
            subList.remove(subList.size()-1);
            vis[i] = 0;
        }
    }
}


// []
// |-----[1]
// |     |-----[1,1]
// |     |     |-----[1,1,2]
// |     |     \-----[1,1,2] (skipped due to duplicate)
// |     \-----[1,2]
// |           |-----[1,2,1]
// |           \-----[1,2,1] (skipped due to duplicate)
// \-----[2]
//       |-----[2,1]
//       |     |-----[2,1,1]
//       |     \-----[2,1,1] (skipped due to duplicate)
//       \-----[2,1]
//             |-----[2,1,1]
//             \-----[2,1,1] (skipped due to duplicate)
