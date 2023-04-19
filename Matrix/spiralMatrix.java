class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        int length = matrix.length*matrix[0].length;
        List<Integer> list = new ArrayList<Integer>();
        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i = colStart;i<=colEnd;i++){
                list.add(matrix[rowStart][i]);
            }
            rowStart++;
            for(int i = rowStart;i<=rowEnd;i++){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            for(int i = colEnd;i>=colStart && list.size()<length;i--){
                list.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            for(int i = rowEnd;i>=rowStart && list.size()<length;i--){
                list.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return list;
    }
}
