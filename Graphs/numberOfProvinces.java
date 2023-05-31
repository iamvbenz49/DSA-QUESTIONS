class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] vis = new int[isConnected.length];
        int count = 0;
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]==0){
                count++;
                dfs(isConnected,vis,i);
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected,int[] vis,int i){
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[j][i]==1 && vis[j]==0){
                vis[i]=1;
                dfs(isConnected,vis,j);
            }
        }
    }
}
