// Recursion TLE
class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums,0,-1);
    }
    public int LIS(int[] nums,int index,int prev){
        if(index>=nums.length)
            return 0;
        int take = 0;
        if(prev==-1 || nums[index]>nums[prev])
            take = 1 + LIS(nums,index+1,index);
        int notTake = LIS(nums,index+1,prev);
        return Math.max(take,notTake);
    }
}

// Dynamic Programming
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>list.get(list.size()-1))
                list.add(nums[i]);
            else
                search(list,nums[i]);
        }
        return list.size();
    }
    public void search(List<Integer> list,int element){
        int start = 0;
        int end = list.size()-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(list.get(mid)>=element)
                end = mid;
            else start = mid+1;
        }
        list.set(start,element);
    }
}
