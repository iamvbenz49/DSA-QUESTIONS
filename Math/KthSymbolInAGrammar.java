class Solution {
    public int kthGrammar(int n, int k) {
        int left = 1, right = (int)Math.pow(2,k-1), res = 0;
        while(left<right){
            int mid = left + (right-left)/2;
            if(k<=mid){
                right = mid;
            }else{
                left = mid + 1;
                res = 1 - res;
            }
        }
        return res;
    }
}
