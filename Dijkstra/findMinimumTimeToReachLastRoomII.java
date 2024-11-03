class Solution {
    public class Pair {
        private int x, y, time, isOdd;
        public Pair(int x,int y, int time, int isOdd) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isOdd = isOdd;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dist[i], (int)1e12);
        }

        dist[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.add(new Pair(0, 0 , dist[0][0], 1));
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!pq.isEmpty()) {
            Pair node = pq.poll();
            int x = node.x, y = node.y, time = node.time, isOdd = node.isOdd;

            if(dist[x][y] < time) {
                continue;
            }
            for(int[] dir: dirs) {
                int dx = dir[0] + x, dy = dir[1] + y;
                if(dx < 0  || dx >= m || dy < 0 || dy >= n) {
                    continue;
                }
                int maxTime = time + (isOdd) + Math.max(moveTime[dx][dy] - time, 0);
                if(maxTime < dist[dx][dy]) {
                    dist[dx][dy] = maxTime ;
                    pq.add(new Pair(dx, dy, dist[dx][dy], isOdd == 1?2:1));
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}