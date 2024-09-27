class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] lineSweep = new int[2051];
        for(int[] log: logs) {
            lineSweep[log[0]]++;
            lineSweep[log[1]]--;
        }
        int res = 0, year = 0;
        for(int i = 1950; i <= 2050; i++) {
            lineSweep[i] += lineSweep[i-1];
            if(res < lineSweep[i]) {
                year = i;
                res = lineSweep[i];
            }
        }
        return year;
    }
}