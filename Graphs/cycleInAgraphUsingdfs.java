

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(adj,vis,i,-1)==true)
                    return true;
            }
        }
        return false;
    }
    public boolean dfs( ArrayList<ArrayList<Integer>> adj,int[] vis,int start,int parent){
        ArrayList<Integer> curr = adj.get(start);
        vis[start] = 1;
        for(int i:curr){
            if(vis[i]==0){
                if(dfs(adj,vis,i,start)==true){
                    return true;
                }
            }
            else if(i!=parent)
                return true;
        }
        return false;
    }
}
