class disjointSetUnion {
    List<Integer> size,parent;
    public disjointSetUnion(int n){
        size = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            size.add(0);
        }
        parent = new ArrayList<>(n+1);;
        for(int i=0;i<=n;i++){
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        parent.set(node,findParent(parent.get(node)));
        return parent.get(node);    
    }
    void unionBySize(int u,int v){
        int ultimateParent_u = findParent(u);
        int ultimateParent_v = findParent(v);
        if(size.get(ultimateParent_u)<size.get(ultimateParent_v)){
            parent.set(ultimateParent_v,size.get(ultimateParent_u));
            size.set(ultimateParent_v,size.get(ultimateParent_v)+size.get(ultimateParent_u));
        }else{
            parent.set(ultimateParent_u,ultimateParent_v);
            size.set(ultimateParent_u,size.get(ultimateParent_v)+size.get(ultimateParent_u));
        }
    }
} 
class Edge implements Comparable<Edge>{
    int src,dest,wt;
    public Edge(int wt,int src,int dest){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    public int compareTo(Edge otherEdge){
        return this.wt-otherEdge.wt;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    List<Edge> adj = new ArrayList<>();
	    for(int[] edge:edges){
	        adj.add(new Edge(edge[2],edge[0],edge[1]));
	    }
	    int sum = 0;
	    disjointSetUnion ds = new disjointSetUnion(V);
	    Collections.sort(adj);
	    for(Edge node:adj){
	        if(ds.findParent(node.src)!=ds.findParent(node.dest)){
	            ds.unionBySize(node.src,node.dest);
	            sum+=node.wt;
	        }
	    }
	    return sum;
	}
}
