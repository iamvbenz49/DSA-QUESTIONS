class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // sort based on price  
        // calculate max beauty for each index
        int ITEMS_SIZE = items.length, QUERIES_SIZE = queries.length;
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int maxBeauty = items[0][1];
        for(int i = 1; i < ITEMS_SIZE; i++) {
            items[i][1] = Math.max(maxBeauty, items[i][1]);
            maxBeauty = items[i][1];
        }

        int[] res = new int[QUERIES_SIZE];

        for(int i = 0; i < QUERIES_SIZE; i++) {
            res[i] = binarySearch(items, queries[i]);
        }
        return res;
    }
    
    public int binarySearch(int[][] items, int target) {
        int start = 0, end = items.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(items[mid][0] <= target) 
                start = mid + 1;
            else 
                end = mid - 1;
        }
        return end == - 1 ? 0 : items[end][1];
    }
}