class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        int[] vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:connections){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int notConnected = 0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(vis,adj,i);
                notConnected++;
            }
        }
        return notConnected-1;
    }
    public void dfs(int[] vis,List<List<Integer>> adj,int start){
        vis[start] = 1;
        for(int node:adj.get(start)){
            if(vis[node]==0){
                dfs(vis,adj,node);
            }
        }
    }
}
