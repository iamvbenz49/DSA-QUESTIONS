class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[][] dp = new int[n][shelfWidth+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        return find(dp, books, shelfWidth, n-1, shelfWidth, 0);
    }
    public int find(int[][] dp, int[][] books, int maxWidth, int index, int width, int height) {
        if(index == 0){
            int pick = (int)1e9;
            if(width - books[index][0] >= 0){
                pick = Math.max(height, books[index][1]);
            }
            int notPick = height + books[index][1];
            return Math.min(pick, notPick);
        }
        if(dp[index][width] != -1) return dp[index][width];

        int pick = (int)1e9;
        if(width - books[index][0] >= 0){
            pick = find(dp, books, maxWidth, index-1, width-books[index][0], Math.max(height, books[index][1]));
        }
        int notPick = height + find(dp, books, maxWidth, index-1, maxWidth-books[index][0], books[index][1]);
        return dp[index][width] = Math.min(pick, notPick);
    }
}
