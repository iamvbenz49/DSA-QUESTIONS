class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                color[i] = 0;
                if(dfs(color,graph,i)==false)
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int[] color,int[][] graph,int start){
        for(int i=0;i<graph[start].length;i++){
            int now = graph[start][i];
            if(color[now]==-1){
                color[now] = 1-color[start];
                if(dfs(color,graph,now)==false){
                    return false;
                }        
            }
            else if(color[now]==color[start]){
                return false;
            }
        }
        return true;
    }
}
