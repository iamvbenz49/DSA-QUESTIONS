import java.util.ArrayList;
import java.util.List;

public class disjointSetRank {
    List<Integer> rank,parent;
    public disjointSetRank(int n){
        rank = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            rank.add(0);
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
    void unionByRank(int u,int v){
        int ultimateParent_u = findParent(u);
        int ultimateParent_v = findParent(v);
        if(rank.get(ultimateParent_u)<rank.get(ultimateParent_v)){
            parent.set(parent.get(ultimateParent_u),ultimateParent_v);
        }else if(rank.get(ultimateParent_u)>rank.get(ultimateParent_v)){
            parent.set(parent.get(ultimateParent_v),ultimateParent_u);
        }else{
            parent.set(ultimateParent_u,ultimateParent_v);
            rank.set(ultimateParent_u,rank.get(ultimateParent_u)+1);
        }
    }
    public static void main(String[] args) {
        disjointSetRank ds = new disjointSetRank(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }
        ds.unionByRank(3, 7);
        if(ds.findParent(3)==ds.findParent(7)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }
    }
}