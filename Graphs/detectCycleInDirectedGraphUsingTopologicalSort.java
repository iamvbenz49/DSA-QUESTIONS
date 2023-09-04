

/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        int size = 0;
        for(int i=0;i<V;i++){
            ArrayList<Integer> list = adj.get(i);
            for(int j=0;j<list.size();j++){
                indegree[list.get(j)]++;
            }
        }
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            size++;
            int now = q.poll();
            ArrayList<Integer> list = adj.get(now);
            for(int j=0;j<list.size();j++){
                indegree[list.get(j)]--;
                if(indegree[list.get(j)]==0){
                    q.add(list.get(j));
                }
            }
        }
        return size!=V;
    }
}
