class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            list.get(edge[0]).add(new int[]{edge[1],edge[2]});
            list.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int res = Integer.MAX_VALUE;
        int city = -1;
        for(int i=0;i<n;i++){
            int[] dist = new int[n];
            Arrays.fill(dist,(int)(1e8));
            dist[i] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[0]-y[0]);
            pq.add(new int[]{0,i});
            while(!pq.isEmpty()){
                int[] node = pq.poll();
                int d = node[0], val = node[1];
                for(int[] vertex:list.get(val)){
                    int vertexN = vertex[0], vertexW = vertex[1];
                    if(dist[val]+vertexW<dist[vertexN]){
                        dist[vertexN] = dist[val]+vertexW;
                        pq.add(new int[]{dist[vertexN],vertexN});
                    }
                }
            }
            int cnt = 0;
            for(int dis:dist){
                if(dis<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=res){
                res = cnt;
                city = i;
            }
        }
        return city;
    }
}
