class Solution {
    private int count = 0;
    public int countGoodNodes(int[][] edges) {
        int max = -1;
        for(int[] edge:edges)
            max = Math.max(max, Math.max(edge[0], edge[1]));
        int[] vis = new int[max+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= max; i++) list.add(new ArrayList<>());
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        dfs(list, vis, 0);
        return count;
    }
    public int dfs(List<List<Integer>> adj, int[] vis, int start) {
        if(vis[start] == 1) return 0;
        boolean check = true;
        int prevSize = -1, totalSize = 0;
        vis[start] = 1;
        for(int node:adj.get(start)) {
            if(vis[node] == 0) {
                int size = dfs(adj, vis, node);
               // System.out.println(size +" "+node);
                if(size != prevSize && prevSize == -1) prevSize = size;
                else if(size != prevSize) prevSize = -2;
                totalSize += size;
            }
        }
        if(prevSize != -2) {
            count++;
          //  System.out.println(start + " " + count);
        }
        return totalSize + adj.get(start).size()-1;
    }
}
