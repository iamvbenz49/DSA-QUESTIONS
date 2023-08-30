
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] v = new int[V];
        int[] pathv = new int[V];
        for(int i=0;i<V;i++){
            if(v[i]==0){
                if(dfs(adj,v,i,pathv)==true){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] v,int start,int[] pathv){
        v[start] = 2;
        int size = adj.get(start).size();
        for(int i=0;i<size;i++){
            int now = adj.get(start).get(i);
            if(v[now]==0){
                if(dfs(adj,v,now,pathv)==true){
                    return true;
                }
            }else if(v[now]==2){
                return true;
            }
        }
        v[start] = 1;
        return false;
    }
}
