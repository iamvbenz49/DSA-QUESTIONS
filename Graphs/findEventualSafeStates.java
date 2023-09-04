class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] pathVis = new boolean[graph.length];
        boolean[] check = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==false){
                if(dfs(graph,vis,check,pathVis,i)){
                    check[i] = true;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<check.length;i++){
            if(check[i]==false){
                list.add(i);
            }
        }
        return list;
    }
    public boolean dfs(int[][] graph,boolean[] vis,boolean[] check,boolean[] pathVis,int start){
        pathVis[start] = true;
        vis[start] = true;
        check[start] = true;
        for(int i=0;i<graph[start].length;i++){
            int curr = graph[start][i];
            if(vis[curr]==false){
                if(dfs(graph,vis,check,pathVis,curr)){
                    return check[curr]= true;
                }
            }
            else if(pathVis[curr]){
                return check[curr]= true;
            }
        }
        check[start] = false;
        pathVis[start] = false;
        return false;
    }
}
