class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // sort them based on start time
        // add the empty rooms to rooms pq
        // our main pq should compare endTime then room number
        // if the meeting in the pq >= current meeting's start time
        // pop it from the queue and push it rooms
        // if pq is full pop any of the meeting and add the endTime by adjusting with original Time
        // else add the original end time and allocate a room to pq normally
        int NUMBER_OF_MEETINGS = meetings.length;
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            rooms.add(i);
        }
        // endTime and room number
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] a, long[] b) {
                if(a[0] == b[0]) {
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[0], b[0]);
            }
        });
        int[] res = new int[n];
        for(int i = 0; i < NUMBER_OF_MEETINGS; i++) {
            int currentStart = meetings[i][0], currentEnd = meetings[i][1];
            while(!pq.isEmpty() && currentStart >= pq.peek()[0]) {
                rooms.add((int)pq.poll()[1]);
            }
            if(pq.size() == n) {
                long[] node = pq.poll();
                long end = node[0], room = node[1];
                res[(int)room]++;
                pq.add(new long[]{(long)end + (currentEnd - currentStart), room});
            } else {
                int room = rooms.poll();
                res[(int)room]++;
                pq.add(new long[]{(long)currentEnd, (long)room});
            }
        }
        int maxRoom = 0, maxMeeting = res[0];
        for(int i = 1; i < n; i++) {
            System.out.println(res[i]+" ");
            if(maxMeeting < res[i]) {
                maxMeeting = res[i];
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}