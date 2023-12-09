class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        disjointSetUnion ds = new disjointSetUnion(n);
        for(int[] edge:connections){
            ds.unionBySize(edge[0],edge[1]);
        }
        int notConnected = 0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i)==i)
                notConnected++;
        }
        return notConnected-1;
    }
    
}
public class disjointSetUnion {
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
