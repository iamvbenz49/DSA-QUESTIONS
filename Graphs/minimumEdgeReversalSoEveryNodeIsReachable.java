class Solution {
    public int[] minEdgeReversals(int n, int[][] edges) {
        int N = edges.length;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < N; i++) {
            adj.get(edges[i][0]).add(new int[]{edges[i][1], 0});
            adj.get(edges[i][1]).add(new int[]{edges[i][0], 1});
        }
        int ans = dfs(adj, -1, 0);
        int[] res = new int[n];
        res[0] = ans;
        dfs2(adj, res, -1, 0);
        return res;
    }
    public int dfs(List<List<int[]>> adj, int parent, int start) {
        int ans = 0;
        for(int[] node: adj.get(start)) {
            if(node[0] != parent) {
                ans += node[1] + dfs( adj, start, node[0]);
            }
        }
        return ans;
    }
    public void dfs2(List<List<int[]>> adj, int[] res, int parent, int start) {
        for(int[] node: adj.get(start)) {
            if(node[0] != parent) {
                if(node[1] == 1) {
                    res[node[0]] = res[start] - 1;
                } else {
                    res[node[0]] = res[start] + 1;
                }
                dfs2(adj, res, start, node[0]);
            }
        }
    }
}