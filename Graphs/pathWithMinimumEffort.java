class Cell{
    int row, col, dist;
    public Cell(int row,int col,int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Cell>pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        pq.add(new Cell(0,0,0));
        int[][] coordinates = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] diff = new int[heights.length][heights[0].length];
        for(int[] arr:diff)
            Arrays.fill(arr,Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            Cell node = pq.poll();
            int nodeRow = node.row;
            int nodeCol = node.col;
            int nodeDist = node.dist;
            if(nodeRow==heights.length-1 && nodeCol==heights[0].length-1)
                return nodeDist;
            for(int[] coordinate:coordinates){
                int row = coordinate[0] + nodeRow;
                int col = coordinate[1] + nodeCol;
                if(row>=0 && col>=0 && row<heights.length && col<heights[0].length){
                    int diffAbs = Math.max(nodeDist,Math.abs(heights[row][col]-heights[nodeRow][nodeCol]));
                    if(diffAbs<diff[row][col]){
                        pq.add(new Cell(row,col,diffAbs));
                        diff[row][col] = diffAbs;
                    }
                }
            }
        }
        return 0;
    }
}
