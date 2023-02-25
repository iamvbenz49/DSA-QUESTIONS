class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r =1;
        int maxProf = 0;
        while(r<prices.length){
            int currProf = prices[r]-prices[l];
            if(prices[l]<prices[r])
                maxProf = Math.max(currProf,maxProf);
            else
                l = r;
            r++;
        }
        return maxProf;
    }
} //pattern used SLIDING WINDOW!
