// TC - O(N) SC - O(N)

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] hashtable = new int[nums.length+1];
        int numberOfTimes = 0;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = hashtable[nums[i]];
            if(result.size()<=index){
                result.add(new ArrayList<>());
            }
            result.get(index).add(nums[i]);
            hashtable[nums[i]]++;
        }
        return result;
    }
}
