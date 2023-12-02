class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int pref = 0;
        int post = 0;
        int n = nums.length-1;
        for(int i=0;i<=n;i++){
            post = nums[i] + post;
        }
        int[] res = new int[n+1];
        for(int i=0;i<=n;i++){
            res[i] = Math.abs((pref - (i*nums[i]))) + Math.abs((post - ((n-i+1)*nums[i])));
            pref += nums[i];
            post -= nums[i];
        }
        return res;
    }
}
