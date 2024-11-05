class Solution {
    private int res = 0;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = parent.length;
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }
        return Math.max(dfs(adj, s, 0, -1), res);
    }
    public int dfs(List<List<Integer>> adj, String s, int start, int parent) {
        int left = 0, right = 0;
        for(int node: adj.get(start)) {
            int path = dfs(adj, s, node, start);
            if(s.charAt(node) != s.charAt(start)) {
                if(left < path) {
                    right = left;
                    left = path;
                } else if(right < path){
                    right = path;
                }
            }
        }
        res = Math.max(left + right + 1, res);

        return left + 1;
    }
}