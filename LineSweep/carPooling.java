class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] lineSweep = new int[1002];
        for(int[] trip: trips) {
            lineSweep[trip[1]] += trip[0];
            lineSweep[trip[2]] -= trip[0];
        }

        for(int i = 0; i < 1002; i++) {
            lineSweep[i] += i == 0?0:lineSweep[i-1];
            if(lineSweep[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}