class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int remove = 0;
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>intervals[i][0]){
                remove++;
            }
            else{
                end = intervals[i][1];
            }
        }
        return remove;
    }
}
