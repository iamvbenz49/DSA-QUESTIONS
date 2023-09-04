class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                System.out.println(i);
                q.add(i);
            }
        }
        int size = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            res[size++] = now;
            List<Integer> list = adj.get(now);
            for(int i=0;i<list.size();i++){
                indegree[list.get(i)]--;
                if(indegree[list.get(i)]==0)q.add(list.get(i));
            }
        }
        if(numCourses!=size){
            return new int[]{};
        }
        return res;
    }
}
