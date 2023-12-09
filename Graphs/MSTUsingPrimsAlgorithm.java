class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    List<List<int[]>> list = new ArrayList<>();
	    for(int i=0;i<V;i++){
	        list.add(new ArrayList<>());
	    }
	    for(int[] edge:edges){
	        list.get(edge[0]).add(new int[]{edge[1],edge[2]});
	        list.get(edge[1]).add(new int[]{edge[0],edge[2]});
	    }
	    int sum = 0;
	    PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[0]-y[0]); // distance node 
	    boolean[] visited = new boolean[V];
	    pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
	        int dist = node[0], val = node[1];
	        if(!visited[val]){
	            visited[val] = true;
	            sum+=dist;
	            for(int[] vertex:list.get(val)){
	                int vertexV = vertex[0], vertexW = vertex[1];
	                if(!visited[vertexV]){
	                    pq.add(new int[]{vertex[1],vertex[0]});
	                }
                }
	       }
	   }
	   return sum;
	}
}
