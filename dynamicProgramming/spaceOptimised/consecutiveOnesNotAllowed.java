// TC - O(N) SC - O(1)

class Solution {
    static long mod = (int)(1e9 + 7);
    long countStrings(int n) {
        if(n<=2)
            return n+1;
        long first = 2, second = 3,third = -1;
        // TC - O(N) 
        for(int i=3;i<=n;i++){
            third = (first + second)%mod;
            first = second;
            second =  third;
        }
        return third%mod;
    }
}
