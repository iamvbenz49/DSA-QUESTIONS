class Solution {
    public boolean isPowerOfThree(int n) {
        int maxThreePower = (int)Math.pow(3,19);
        return n>0 && maxThreePower%n==0;
    }
}
