class Solution {
    public int countNegatives(int[][] arr) {
        int row = arr.length-1;
        int col = 0;
        int total =0;
        while(row>=0 && col<arr[0].length){
            int current = arr[row][col];
            if(current<0){
                total += arr[0].length - col;
                row--;
            }
            else{
                col++;
            }
        }
        return total;
    }
}
