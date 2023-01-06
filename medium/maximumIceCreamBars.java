class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int r =0;
        for(int i=0;i<costs.length;i++){
            if(coins-costs[i]<0){
                break; 
            }
            coins = coins-costs[i];
            r++;
        }
        return r;
    }
}
