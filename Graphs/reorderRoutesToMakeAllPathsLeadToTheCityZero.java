class Solution {
    // Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
    // Output: 3
    // Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

    public int minReorder(int n, int[][] connections) {
        // int[] -> node, weight
        int N = connections.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < N; i++) {
            adj.get(connections[i][0]).add(new int[]{connections[i][1], 1});
            adj.get(connections[i][1]).add(new int[]{connections[i][0], 0});
        }
        int[] vis = new int[n];
        return dfs(adj, vis, 0);
    }
    public int dfs(List<List<int[]>> adj, int[] vis, int start) {
        vis[start] = 1;
        int ans = 0;
        for(int[] node: adj.get(start)) {
            if(vis[node[0]] == 0) {
                ans += node[1] + dfs(adj, vis, node[0]);
            }
        }
        return ans;
    }
}