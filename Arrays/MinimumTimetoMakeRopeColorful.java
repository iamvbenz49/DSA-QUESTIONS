class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        int right = 1;
        while(right<colors.length()){
            if(colors.charAt(right-1)==colors.charAt(right)){
                res += Math.min(neededTime[right],neededTime[right-1]);
                neededTime[right] = Math.max(neededTime[right],neededTime[right-1]);
            }
            right++;
        }
        return res;
    }
}
