class minimumObstacleRemovalToReachCorner {
    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<Pair> deque = new LinkedList<>();
        int[][] dist = new int[ROWS][COLS];

        for(int i = 0; i < ROWS; i++) {
            Arrays.fill(dist[i], (int)1e9);
        }
        deque.add(new Pair(0, 0));
        dist[0][0] = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!deque.isEmpty()) {
            Pair node = deque.pollFirst();
            int x = node.row, y = node.col;
            for(int[] dir: dirs) {
                int dx = x + dir[0], dy = y + dir[1];
                if(!checkBoundary(dx, dy, ROWS, COLS)) {
                    if(dist[x][y] + grid[dx][dy] < dist[dx][dy]) {
                        dist[dx][dy] = dist[x][y] + grid[dx][dy];
                        if(grid[dx][dy] == 0) {
                            deque.offerFirst(new Pair(dx, dy));
                        } else {
                            deque.offerLast(new Pair(dx, dy));
                        }
                    }
                }
            }
        }
        return dist[ROWS - 1][COLS - 1];
    }
    public boolean checkBoundary(int x, int y, int ROWS, int COLS) {
        return x < 0 || y < 0 || x >= ROWS || y >= COLS; 
    }
}