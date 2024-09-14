// STRIVER sheet greedy 
// Link - https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1



class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        int[][] res = new int[n][2];
        for(int i = 0;  i < n; i++) {
            res[i] = new int[]{end[i], start[i]};
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        
        int lastElement = 0, count = 0;
        for(int i = 0; i < n; i++) {
            if(res[i][1] > lastElement) {
                lastElement = res[i][0];
                count++;
            }
        }
        return count;
  }
}