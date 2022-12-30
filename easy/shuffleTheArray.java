class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n*2];
        int c=0;
        for(int i=0,j=n;i<n;i++,j++){
            res[c++]=nums[i];
            res[c++]=nums[j]; 
        }
        return res;
    }
}
