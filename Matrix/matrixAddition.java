class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] rotated = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix.length;j++){
                rotated[i][j] = matrix[j][i];
            }
        }
        return rotated;
    }
}
