class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        int level = 1;
        q.add(new int[]{0,0});
        int[][] coordinates = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] node = q.poll();
                if(node[0]==grid.length-1 && node[1]==grid[0].length-1){
                    return level;
                }
                for(int[] coordinate:coordinates){
                    int r = node[0] + coordinate[0];
                    int c = node[1] + coordinate[1];
                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==0){
                        q.add(new int[]{r,c});
                        grid[r][c] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
