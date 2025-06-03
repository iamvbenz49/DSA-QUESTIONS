class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        Queue<Integer> q = new LinkedList<>();

        for(int box: initialBoxes) {
            q.add(box);
        }

        int res = 0; 
        boolean found = true;
        while(!q.isEmpty() && found) {
            int size = q.size();
            found = false;
            for(int i = 0; i < size; i++) {
                int node = q.poll();
                if(status[node] == 0) {
                    System.out.println(node);
                    q.add(node);
                    continue;
                }
                found = true;
                res += candies[node];
                for(int box: containedBoxes[node]) {
                    q.add(box);
                }
                for(int key: keys[node]) {
                    System.out.println(key);
                    status[key] = 1;
                }
            }
        }
        return res;
    }
}
