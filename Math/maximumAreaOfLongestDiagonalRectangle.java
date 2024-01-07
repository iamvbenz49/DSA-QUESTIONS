class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int length = -1, breadth = -1;
        double diagonal = -1;
        for(int[] dimension:dimensions){
            int dx = dimension[0], dy = dimension[1];
            double d = Math.pow(dx,2) + Math.pow(dy,2);
            if(d>diagonal){
                diagonal = d;
                length = dx;
                breadth = dy;
            }else if(d==diagonal && dx*dy>length*breadth){
                length = dx;
                breadth = dy;
            }
        }
        return length*breadth;
    }
}
