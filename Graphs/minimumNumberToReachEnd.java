class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[(int)Math.pow(10,5)+1];
        Arrays.fill(dist,(int)1e9);
        dist[start] = 0;
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] node = q.poll();
                int val = node[0], distance = node[1];
                if(val==end)
                    return distance;
                for(int vertex:arr){
                    int num = (val*vertex)%mod;
                    if(dist[val]+1<dist[num]){
                        dist[num] = dist[val]+1;
                        q.add(new int[]{num,dist[num]});
                    }
                }
            }
        }
        return -1;
    }
}
