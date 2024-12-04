class Solution {
    // Video Reference - https://www.youtube.com/watch?v=GSBLe8cKu0s
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // seperate into start and end coordinates
        List<int[]> coordinates = new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();

        for(int[] building: buildings) {
            coordinates.add(new int[]{building[0], -building[2]});
            coordinates.add(new int[]{building[1], building[2]});
        }
        // sort them based on start coordinates
        // if start coordinates are same then try end coordinates

        Collections.sort(coordinates, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        }); 

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.add(0);
        int prev = 0;

        for(int[] coordinate: coordinates) {
            if(coordinate[1] < 0) {
                pq.add(-coordinate[1]);
            } else {
                pq.remove(coordinate[1]);
            }
            int currentMax = pq.peek();
            if(currentMax != prev) {
                List<Integer> temp = new ArrayList<>();
                temp.add(coordinate[0]);
                temp.add(currentMax);
                result.add(temp);
                prev = currentMax;
            }
        }
        return result;
    }
}