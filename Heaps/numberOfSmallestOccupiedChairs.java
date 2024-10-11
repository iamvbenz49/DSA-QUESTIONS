class Solution {
    public class Time {
        private int start, end, index;
        public Time() {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
    public int smallestChair(int[][] times, int targetFriend) {
        int N = times.length;
        Time[] timeWithIndex = new Time[N];

        for(int i = 0; i < N; i++) {
            timeWithIndex[i] = new Time();
            timeWithIndex[i].start = times[i][0];
            timeWithIndex[i].end = times[i][1];
            timeWithIndex[i].index = i;
        }

        Arrays.sort(timeWithIndex, new Comparator<Time>() {
            @Override
            public int compare(Time t1, Time t2) {
                if (t1.start == t2.start) {
                    return t1.end - t2.end;
                }
                return t1.start - t2.start;
            }
        });

        int count = 0;
        int endTime = 0;
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            availableChairs.add(i);
        }
        // leaving time & chairsNumber
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < N; i++) {
            int start = timeWithIndex[i].start;
            int end = timeWithIndex[i].end;
            int index = timeWithIndex[i].index;

            while(!pq.isEmpty() && pq.peek()[0] <= start) {
                availableChairs.add(pq.poll()[1]);
            }
            int chair = availableChairs.poll();
            if(index == targetFriend) {
                return chair;
            }
            pq.add(new int[]{end, chair});
        }
        return pq.size();
    }
}