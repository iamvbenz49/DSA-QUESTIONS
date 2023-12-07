class Pair {
    public int distance, node;

    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
class Solution
{
   
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance);
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
           dist[i] = (int)1e9;
        }   
        dist[S] = 0;
        pq.add(new Pair(0,S));
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int distOfNode = node.distance;
            int valOfNode = node.node;
            for(ArrayList<Integer> vertex:adj.get(valOfNode)){
                int distOfVertex = vertex.get(1);
                int valOfVertex = vertex.get(0);
                if(dist[valOfNode]+distOfVertex<dist[valOfVertex]){
                   dist[valOfVertex] = dist[valOfNode]+distOfVertex;
                   pq.add(new Pair(dist[valOfVertex],valOfVertex));
                }
            }
        }
        return dist;
    }
}
