class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        int[][] coordinates = {{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1},{0,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                double sum = 0, total = 0;
                for(int[] coordinate:coordinates){
                    int dx = i + coordinate[0], dy = j + coordinate[1];
                    if(dx>=0 && dy>=0 && dx<m && dy<n){
                        sum += img[dx][dy];
                        total ++;
                    }
                }
                res[i][j] = (int)(Math.floor(sum/total));
            }
        }
        return res;
    }
}
