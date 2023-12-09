class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=(int)1e8;
                }
            }
        }
        for(int k=0;k<matrix.length;k++){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix.length;j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
         for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]==(int)1e8){
                    matrix[i][j]=-1;
                }
            }
        }
    }
}
