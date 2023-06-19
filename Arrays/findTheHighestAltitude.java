class Solution {
    public int largestAltitude(int[] gain) {
        int prevMax = 0;
        int currMax = 0;
        for(int i=0;i<gain.length;i++){
            currMax += gain[i];
            prevMax = Math.max(currMax,prevMax);
        }
        return prevMax;
    }
}
