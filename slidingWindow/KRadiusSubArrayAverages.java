class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        if(nums.length<=2*k){
            return res;
        }
        int i=0,j=2*k + 1;
        long s=0;
        for(int m=0;m<j;m++){
            s+=nums[m];
        }
        res[k]=(int)(s/(2*k+1));
        while(j<nums.length){
            
            s = s-nums[i]+nums[j];
            i++;
            res[j-k] = (int)(s/(2*k+1));
            j++;
        }
        return res;
    }
}
