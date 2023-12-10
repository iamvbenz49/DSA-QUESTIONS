class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[V];
        int scc = 0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(stack,adj,vis,i);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++){
            vis[i] = 0;
            for(int node:adj.get(i))
                adjT.get(node).add(i);
        }
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(vis[node]==0){
                scc++;
                dfsT(adjT,vis,node);
            }
        }
        return scc;
    }
    public void dfs(Stack<Integer> stack,ArrayList<ArrayList<Integer>> adj,int[] vis,int start){
        vis[start] = 1;
        for(int node:adj.get(start)){
            if(vis[node]==0){
                dfs(stack,adj,vis,node);
            }
        }
        stack.add(start);
    }
    public void dfsT(ArrayList<ArrayList<Integer>> adj,int[] vis,int start){
        vis[start] = 1;
        for(int node:adj.get(start)){
            if(vis[node]==0){
                dfsT(adj,vis,node);
            }
        }
    }
}
