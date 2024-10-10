class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        int N = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0] , a[0]));
        
        for(int i = 0; i < N; i++) {
            double valuePerWeight = (double)arr[i].value / (double)arr[i].weight;
            pq.add(new double[]{valuePerWeight, arr[i].value, arr[i].weight});
        }
        double res = 0;
        while(w > 0 && !pq.isEmpty()) {
            double[] node = pq.poll();
            double ratio = node[0], val = node[1], wt = node[2];
            if(w - wt >= 0) {
                // System.out.println(val+" "+wt);
                w -= wt;
                // System.out.println(w);
                res += val;
            } else {
                res += ((val / wt) * w);
                w = 0;
                break;
            }
        }
        return res;
    }
}