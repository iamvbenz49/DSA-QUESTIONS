class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });

        int[][] process = new int[n][3];  
        for(int i = 0; i < n; i++) {
            process[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(process, new Comparator<int[]>() {
            @Override
            public int compare(int[] s1, int[] s2) {
                if(s1[0] == s2[0]) {
                    return Integer.compare(s1[1], s2[1]);
                }
                return Integer.compare(s1[0], s2[0]);
            }
        });
      //  System.out.println(Arrays.deepToString(process));
        int taskIndex = 0, resIndex = 0, currentTime = 0;
        int[] res = new int[n];
        while(taskIndex < n || !pq.isEmpty()) {
            while(taskIndex < n && process[taskIndex][0] <= Math.min(process[taskIndex][0], currentTime)) {
                pq.add(process[taskIndex++]);
            }
            if(pq.isEmpty()) { 
                pq.add(process[taskIndex++]);
            }

            int[] task = pq.poll();
            res[resIndex++] = task[2];
            currentTime = Math.max(currentTime + task[1], task[0] + task[1]);
        }       
        return res;
    }
}

// Link - https://leetcode.com/problems/single-threaded-cpu/description/

// Algorithm

//     Lets sort all the task according to their start Time first ( its not given that task vector is sorted )
//     Next we will make a priority queue which maintains the shortest task, ie. task with shortest processing time on the top.
//     maintain a currTime variable this is going to track down current Time, using this we will push tasks in queue.
//     If at particular time queue is empty then we need to push the next task in sequence.
