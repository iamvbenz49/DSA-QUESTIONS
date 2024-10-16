class Solution {
    public int minCost(int n, int[] cut) {
        List<Integer> cuts = new ArrayList<>();
        for (int c : cut) {
            cuts.add(c);
        }
        cuts.add(0);
        cuts.add(n);
        Collections.sort(cuts);
        int cutLen = cut.length;
        int[][] dp = new int[cutLen + 2][cutLen + 2];
        for(int i = 0; i < cutLen + 2; i++)
            Arrays.fill(dp[i], - 1);
        return find(dp, cuts, 1, cuts.size() - 2);
    }
    public int find(int[][] dp, List<Integer> cuts, int start, int end) {
        if(start > end) {
            return 0;
        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }
        int res = (int)1e9;

        for(int i = start; i <= end; i++) {
            res = Math.min(
                res,
                cuts.get(end + 1) - cuts.get(start - 1) + find(dp, cuts, start, i - 1) + find(dp, cuts, i + 1, end)
            );
        }

        return dp[start][end] = res;
    }
}

class Solution {
    public int minCost(int n, int[] cut) {
        List<Integer> cuts = new ArrayList<>();
        for (int c : cut) {
            cuts.add(c);
        }
        cuts.add(0);
        cuts.add(n);
        Collections.sort(cuts);
        int cutLen = cut.length;
        int[][] dp = new int[cutLen + 2][cutLen + 2];
        // for(int i = 0; i < cutLen + 2; i++)
        //     Arrays.fill(dp[i], - 1);

        for(int start = cutLen; start >= 1; start--) {
            for(int end = 1; end <= cutLen; end++) {
                if(start > end) {
                    continue;
                }
                int res = (int)1e9;

                for(int i = start; i <= end; i++) {
                    res = Math.min(
                        res,
                        cuts.get(end + 1) - cuts.get(start - 1) + dp[start][i - 1] + dp[i + 1][end]
                    );
                }
                dp[start][end] = res;
            }
        }
        return dp[1][cutLen];
    }
    public int find(int[][] dp, List<Integer> cuts, int start, int end) {
        if(start > end) {
            return 0;
        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }
        int res = (int)1e9;

        for(int i = start; i <= end; i++) {
            res = Math.min(
                res,
                cuts.get(end + 1) - cuts.get(start - 1) + find(dp, cuts, start, i - 1) + find(dp, cuts, i + 1, end)
            );
        }

        return dp[start][end] = res;
    }
}