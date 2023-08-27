class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1 && bfs(color,graph,i)==false){
                return false;
            }
        }
        return true;
    }
    public boolean bfs(int[] color,int[][] graph,int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            int size = graph[curr].length;
            for(int i=0;i<size;i++){
                int now = graph[curr][i];
                if(color[now]==-1){
                    color[now] = 1-color[curr];
                    q.add(now);
                }
                else if(color[now]==color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}
