class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges==0){
            return 0;
        }
        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                if(row>0 && grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    q.offer(new int[]{row-1,col});
                    freshOranges--;
                }
                if(row<grid.length-1 && grid[row+1][col]==1){
                    grid[row+1][col]=2;
                    q.offer(new int[]{row+1,col});
                    freshOranges--;
                }
                if(col>0 && grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    q.offer(new int[]{row,col-1});
                    freshOranges--;
                }
                if(col<grid[0].length-1 && grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    q.offer(new int[]{row,col+1});
                    freshOranges--;
                }
            }
            minutes++;
        }
        return freshOranges==0?minutes-1:-1;
    }
}
