class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][1]]++;
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                System.out.println(indegree[i]);
            }
        }
        int size = 0;
        while(!q.isEmpty()){
            size++;
            int now = q.poll();
            List<Integer> list = adj.get(now);
            for(int i=0;i<list.size();i++){
                indegree[list.get(i)]--;
                if(indegree[list.get(i)]==0)q.add(list.get(i));
            }
        }
        return size==numCourses;
    }
}
