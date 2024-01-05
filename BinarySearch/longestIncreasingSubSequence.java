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
