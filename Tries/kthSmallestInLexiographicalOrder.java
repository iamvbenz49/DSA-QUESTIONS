// 440. K-th Smallest in Lexicographical Order
// Given two integers `n` and `k`, return the k-th lexicographically smallest integer in the range [1, n].
// Constraints: 1 <= k <= n <= 10^9

class Solution {
    public int findKthNumber(int n, int k) {
        long currentNumber = 1;
        while (k > 1) {
            long steps = findSteps(currentNumber, currentNumber + 1, n);
            if (steps < k) {
                currentNumber++;
                k -= steps;
            } else {
                currentNumber = currentNumber * 10;
                k--;
            }
        }
        return (int) currentNumber;
    }

    public long findSteps(long lowerBound, long upperBound, int maxNumber) {
        long steps = 0;
        while (lowerBound <= maxNumber) {
            steps += Math.min(maxNumber + 1, upperBound) - lowerBound;
            lowerBound *= 10;
            upperBound *= 10;
        }
        return steps;
    }
    
}
