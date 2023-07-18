class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int c=0;c<=3;c++){
            int[][] rotated = new int[mat.length][mat.length];
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat.length;j++){
                    rotated[j][mat.length-i-1] = mat[i][j];
                }
            }
            if(Arrays.deepEquals(target,rotated)){
                return true;
            }
            mat = rotated;
        }
        return false;
    }
}
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int rotate0 = 0;
        int rotate90 = 0; 
        int rotate180 = 0;
        int rotate270 = 0;  
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==target[i][j]){
                    rotate0++;
                }
                if(mat[n-j-1][i]==target[i][j]){
                    rotate90++;
                }
                if(mat[n-1-i][n-1-j]==target[i][j]){
                    rotate180++;
                }
                if(mat[j][n-1-i]==target[i][j]){
                    rotate270++;
                }
            }
        }
        if(rotate0==n*n||rotate90==n*n||rotate270==n*n||rotate180==n*n){
            return true;
        }
        return false;
    }
}
