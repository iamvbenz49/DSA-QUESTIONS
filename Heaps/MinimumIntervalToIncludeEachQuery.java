class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;

        int[][] queriesWithIndex = new int[n][2];

        for(int i = 0; i < n; i++) {
            queriesWithIndex[i] = new int[]{queries[i], i};
        }

        Arrays.sort(intervals, (a, b) -> (
            a[0] - b[0]
        ));

        Arrays.sort(queriesWithIndex, (a, b) -> (
            a[0] - b[0]
        ));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (
                (a[1] - a[0]) - (b[1] - b[0])
            )
        );
        int index = 0;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            int currentVal = queriesWithIndex[i][0];
            int currentIdx = queriesWithIndex[i][1];
            while(index < intervals.length &&  intervals[index][0] <= currentVal) {
                pq.add(intervals[index]);
                index++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < currentVal) {
                pq.poll();
            }
            result[currentIdx] = pq.isEmpty() ? -1 : pq.peek()[1] - pq.peek()[0] + 1;
        }
        return result;
    }
}
