class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i=1;i<intervals.length;i++){
            int[] arr = list.get(list.size()-1);
            if(arr[1]>=intervals[i][0]){
                arr[1] = Math.max(arr[1],intervals[i][1]);
            }
            else{
                list.add(intervals[i]);
            }
        }
        
        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
