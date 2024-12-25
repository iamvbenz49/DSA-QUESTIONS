class Solution {
    int MOD = (int)1e9 + 7;
    public int maxSum(int[] nums1, int[] nums2) {
        // Go all up
        // Go all down
        // If equal then choose maximum

        int up = 0, down = 0, M = nums1.length, N = nums2.length;
        long upSum = 0, downSum = 0;
        while(up < M || down < N) {
            if(up < M && (down == N || nums1[up] < nums2[down])) {
                upSum += nums1[up];
                up++;
            } else if(down < N && (up == M || nums2[down] < nums1[up])) {
                downSum += nums2[down];
                down++;
            } else {
                upSum = downSum = Math.max(upSum, downSum) + nums1[up];
                up++;
                down++;
            }
        }
        return (int)(Math.max(upSum, downSum)%MOD);
    }
}