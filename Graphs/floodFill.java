class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image,image[sr][sc],sr,sc, color);
        return image;
    }
    public void dfs(int[][] image,int color,int row,int col,int change){
        if(row>=0 && row<image.length && col>=0 && col<image[0].length && image[row][col]==color &&color!=change){
            image[row][col] = change;
            dfs(image,color,row+1,col,change);
            dfs(image,color,row-1,col,change);
            dfs(image,color,row,col+1,change);
            dfs(image,color,row,col-1,change);
        }
    }
}
