class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            list.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = (int)1e9;
        }
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,src});
        while(!q.isEmpty() && k!=-1){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] node = q.poll();
                int distance = node[0], val = node[1];
                if(node[1]==dst){
                    continue;
                }
                for(int[] vertex:list.get(val)){
                    int vertexNode = vertex[0], vertexW = vertex[1];
                    if(distance+vertexW<dist[vertexNode]){
                        dist[vertexNode] = distance+vertexW;
                        q.add(new int[]{dist[vertexNode],vertexNode});
                    }
                }
            }
            k--;
        }
        if(k>=-1 && dist[dst]!=(int)1e9){
            return dist[dst];
        }
        return -1;
    }
}
