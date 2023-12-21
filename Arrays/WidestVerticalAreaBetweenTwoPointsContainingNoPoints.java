// TC - O(N)  SC - O(N)

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<points.length;i++)
            set.add(points[i][0]);
        int prev = -1,diff = 0;
        for(int num:set){
            if(prev==-1){
                prev = num;
            }else{
                diff = Math.max(diff,num-prev);
                prev = num;
            }
        }
        return diff;
    }
}
// TC - O(N log N) SC - O(log N)
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int difference = 0;
        for(int i=0;i<points.length-1;i++){
            difference = Math.max(points[i+1][0] - points[i][0],difference);
        }
        return difference;
    }
}
