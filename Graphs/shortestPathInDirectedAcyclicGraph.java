class Pair{
    int node;
    int weight;
    public Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		List<List<Pair>> adj = new ArrayList<>();
		for(int i=0;i<N;i++)
		    adj.add(new ArrayList<>());
	    for(int i=0;i<edges.length;i++){
	        int u = edges[i][0], v = edges[i][1],w = edges[i][2];
	        adj.get(u).add(new Pair(v,w));
	    }
	    Stack<Integer> stack = new Stack<>();
	    int[] vis = new int[N];
	    for(int i=0;i<vis.length;i++){
	        if(vis[i]==0){
	            dfs(adj,vis,stack,i);
	        }
	    }
	    int[] dist = new int[N];
	    for(int i=0;i<N;i++){
	        dist[i] = (int)(1e9);
	    }
	    dist[0] = 0;
	    while(!stack.isEmpty()){
	        int node = stack.pop();
	        for(Pair vertex:adj.get(node)){
	            int v = vertex.node, w = vertex.weight;
	          //  System.out.println(v+" "+w);
	            if(dist[node]+w<dist[v]){
	                dist[v] = dist[node]+w;
	            }
	        }
	    }
	    for(int i=0;i<N;i++){
	        if(dist[i]==(int)(1e9)){
	            dist[i] = -1;
	        }
	    }
		return dist;
	}
	public void dfs(List<List<Pair>> adj,int[] vis,Stack<Integer> stack,int start){
	    vis[start] = 1;
	    for(Pair vertex:adj.get(start)){
	        if(vis[vertex.node]==0){
	            dfs(adj,vis,stack,vertex.node);
	        }
	    }
	    stack.add(start);
	}
}   
