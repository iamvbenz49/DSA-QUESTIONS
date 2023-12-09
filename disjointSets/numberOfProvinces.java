import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) {
        disjointSetUnion ds = new disjointSetUnion(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }
        ds.unionBySize(3, 7);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }
    }
} 
class Solution {
    public int findCircleNum(int[][] isConnected) {
        disjointSetUnion ds = new disjointSetUnion(isConnected.length);
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    ds.unionBySize(i,j);
                }
            }
        }
        int res = 0;
        for(int i=0;i<isConnected.length;i++){
            if(ds.findParent(i)==i)
                res++;
        }
        return res;
    }
}
