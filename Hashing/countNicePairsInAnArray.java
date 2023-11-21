class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer,Integer> set = new HashMap<>();
        int count = 0,mod = (int)1e9 + 7;
        for(int i=0;i<nums.length;i++){
            int rev = reverse(nums[i]);
            if(set.containsKey(nums[i]-rev)){
                set.put(nums[i]-rev,set.get(nums[i]-rev)+1);
                count = (count + set.get(nums[i]-rev))%mod;
            }else{
                set.put(nums[i]-rev,0);
            }
        }
        return count;
    }
    public int reverse(int n){
        int res = 0;
        while(n!=0){
            res = (res*10) + (n%10);
            n/=10;
        }
        return res;
    }
}
