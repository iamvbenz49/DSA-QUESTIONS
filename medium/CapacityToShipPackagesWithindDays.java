class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int e = 0;
        for(int i:weights){
            s = Math.max(i,s);
            e+=i;
        }
        int ans=0;
        while(s<=e){
            int m = s + (e-s)/2;
            if(checkLessDays(m,days,weights)){
                ans = m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return ans;
    }
    public boolean checkLessDays(int mid,int days,int[] weights){
        int reqDays = 1;
        int curr = 0;
        for(int i:weights){
            if(curr+i>mid){
                curr = 0;
                reqDays++;
            }
            curr+=i;
        }
        if(reqDays>days)
            return false;
        else
            return true;
    }
}
