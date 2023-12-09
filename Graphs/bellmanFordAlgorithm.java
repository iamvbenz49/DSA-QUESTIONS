class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)1e8;
        }
        dist[S] = 0;
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> edge:edges){
                int u = edge.get(0), v = edge.get(1), w = edge.get(2);
                if(dist[u]!=1e8 && dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                }
            }
        }
        for(ArrayList<Integer> edge:edges){
                int u = edge.get(0), v = edge.get(1), w = edge.get(2);
                if(dist[u]!=1e8 && dist[u]+w<dist[v]){
                    int[] temp  = {-1};
                    return temp;
                }
        }
        return dist;
    }
}
