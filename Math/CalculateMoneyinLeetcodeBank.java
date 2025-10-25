class Solution {
    public int totalMoney(int n) {
        int q = n/7, r = n%7;
        // Sum of full weeks= 28q + 7× ((q−1)q​)/2
        int fullWeeks = 28 * q;
        int fullWeeksRemain = 7 * q * (q - 1)/2;
        // https://leetcode.com/problems/calculate-money-in-leetcode-bank/solutions/7298375/arithmetic-progression-o-1-don-t-downvote-intentionally
        int remains = (((q + r) * (q + r + 1))/2) - ((q * (q + 1))/2);
        return fullWeeks + fullWeeksRemain + remains;
    }
}
