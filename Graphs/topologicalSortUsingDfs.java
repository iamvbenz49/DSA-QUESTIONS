

/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(adj,stack,vis,i);
            }
        }
        int[] res = new int[V];
        for(int i=0;i<V;i++){
            res[i] = stack.pop();
        }
        return res;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack,int[] vis,int start){
        vis[start] = 1;
        for(int i=0;i<adj.get(start).size();i++){
            int curr = adj.get(start).get(i);
            if(vis[curr]==0){
                dfs(adj,stack,vis,curr);
            }
        }
        stack.add(start);
    }
}
