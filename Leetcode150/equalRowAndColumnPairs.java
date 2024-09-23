class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid.length; j++) {
                sb.append(grid[i][j]+":");
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i]+":");
            }

            if(map.containsKey(sb.toString()))
                res += map.get(sb.toString());
        }
        return res;
    }
}