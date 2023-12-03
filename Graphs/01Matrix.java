class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    System.out.println(i+" "+j);
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0], col = node[1];
            System.out.println(node[0]+" "+node[1]);
            for(int[] dir:dirs){
                int x = row + dir[0];
                int y = col + dir[1];
                if(x<0||y<0||x>=mat.length||y>=mat[0].length||mat[x][y]!=-1)
                    continue;
                mat[x][y] = mat[row][col]+1;
                q.add(new int[]{x,y});
            }
        }
        return mat;
    }
}
