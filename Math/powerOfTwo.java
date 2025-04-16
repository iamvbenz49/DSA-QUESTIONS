class Solution {
    public boolean isPowerOfTwo(int n) {
        // we cant form 2^x such that 2^x = -2 , -4, -8 etc
        return n > 0 && (n & (n - 1)) == 0;
    }
}