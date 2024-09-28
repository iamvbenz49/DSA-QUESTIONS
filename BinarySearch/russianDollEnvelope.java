// Find the Longest Increasing subsequence for the array of height beacause the width is sorted

// MLE
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];  
                } else {
                    return b[1] - a[1];  
                }
            }
        });
        int[][] dp = new int[n][n+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return find(dp, envelopes, 0, -1);
    }
    public int find(int[][] dp, int[][] envelopes, int index, int prevIndex) {
        if(index == envelopes.length) {
            return 0;
        }
        if(dp[index][prevIndex + 1] != -1){
            return dp[index][prevIndex + 1];
        }
        int take = 0;
        if((prevIndex == -1) || (envelopes[index][1] > envelopes[prevIndex][1])) {
            take = 1 + find(dp, envelopes, index + 1, index);
        }
        int notTake = find(dp, envelopes, index + 1, prevIndex);
        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }
}

// same logic as LIS Binary search
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];  
                } else {
                    return b[1] - a[1];  
                }
            }
        });

        List<Integer> res = new ArrayList<>();
        for(int[] height: envelopes) {
            if(res.size() == 0 || res.get(res.size() - 1) < height[1]) {
                res.add(height[1]);
            } else {
                binarySearch(res, height[1]);
            }
        }

        return res.size();
    }
    public void binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            int number = list.get(mid);
            if(number < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        list.set(left, target);
    }
}