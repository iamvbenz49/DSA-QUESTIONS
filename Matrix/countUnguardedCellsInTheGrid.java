class countUnguardedCellsInTheGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // 0 - empty
        // 1 - wall 
        // 2 - guard

        for(int[] guard: guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        for(int[] wall: walls) {
            grid[wall[0]][wall[1]] = 1;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    visitAll(grid, i, j, m, n);
                }
            }
        }
        int res = 0; 
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
    public void visitAll(int[][] grid, int row, int col, int m, int n) {
        for(int i = row + 1; i < m; i++) {
            if(grid[i][col] > 0 && grid[i][col] < 3) {
                break;
            }
            grid[i][col] = 3;
        }
        for(int i = row - 1; i >= 0; i--) {
            if(grid[i][col] > 0 && grid[i][col] < 3) {
                break;
            }
            grid[i][col] = 3;
        }
        for(int i = col + 1; i < n; i++) {
            if(grid[row][i] > 0 && grid[row][i] < 3) {
                break;
            }
            grid[row][i] = 3;
        }
        for(int i = col - 1; i >= 0; i--) {
            if(grid[row][i]  > 0 && grid[row][i] < 3) {
                break;
            }
            grid[row][i] = 3;
        }
    }
}