class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        if ((n - m) != 1) {
            return false;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge:edges){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        int[] vis = new int[n];
        findCycle(adj,vis,0);
        for(int i=0;i<n;i++){
            if(vis[i]==0)
                return false;
        }
        return true;
    }
    public static void findCycle(ArrayList<ArrayList<Integer>> adj,int[] vis,int index){
        vis[index] = 1;
        for(int node:adj.get(index)){
            if(vis[node]==0) findCycle(adj,vis,node);
        }
    }
}
