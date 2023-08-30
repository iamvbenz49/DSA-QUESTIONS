class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] v = new int[V];
        for(int i=0;i<V;i++){
            if(v[i]==0 && bfs(i,v,adj)==true){
                return true;
            }
        }
        return false;
    }
    public boolean bfs(int start,int[] v,ArrayList<ArrayList<Integer>> adj){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,-1});
        v[start]=1;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            List<Integer> list = new ArrayList<>();
            list = adj.get(curr[0]);
            for(int i=0;i<list.size();i++){
                int val = list.get(i);
                if(v[val]==0){
                    q.add(new int[]{val,curr[0]});
                    v[val]=1;
                }
                else if(v[val]==1 && curr[1]!=val){
                    return true;
                }
            }
        }
        return false;
    }
}
