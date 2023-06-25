class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        int ans = 0;
        for(int i=0;i<piles.length;i++){
            right = Math.max(right,piles[i]);
        }
        while(left<=right){
            int mid = left + (right-left)/2;
            if(check(piles,mid,h)){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
    public boolean check(int[] piles,int k,int h){
        for(int i=0;i<piles.length;i++){
            if(piles[i]%k==0){
                h-=piles[i]/k;
            }
            else{
                h-=(piles[i]/k)+1;
            }
            if(h<0){
                return false;
            }
        }
        return true;
    }
}
