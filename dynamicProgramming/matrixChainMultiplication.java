class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        // here everything is induividual matrix
        // we need to find an efficient way to calculate the order in which they should 
        // be multiplied so that the number of induividual multiplications can 
        // be reduced, here the product of scalars operations are reduced
        // Dim( A ) = p x r  Dim( B ) = r x s
        // the resultant would be p x s
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        return find(dp, arr, 1, N - 1);
        
    }
    public static int find(int[][] dp, int[] arr, int left, int right) {
        if(left == right) {
            return 0;
        }
        if(dp[left][right] != -1) {
            return dp[left][right];
        }
        int res = (int)1e9;
        for(int i = left; i < right; i++) {
            res = Math.min(
                res,
                (arr[i] * arr[left - 1] * arr[right]) +
                find(dp, arr, left, i) + find(dp, arr, i + 1, right)
            );
        }
        return dp[left][right] = res;
    }
}