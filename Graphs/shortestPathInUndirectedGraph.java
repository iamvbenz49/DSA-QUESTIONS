class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int vertex:list.get(node)){
                if(dist[node]+1<dist[vertex]){
                    dist[vertex] = dist[node]+1;
                    q.add(vertex);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==(int)1e9)
                dist[i] = -1;
        }
        return dist;
    }
}
