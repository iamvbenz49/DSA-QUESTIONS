class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }
}

// What does i >> 1 even do?

// It’s just right shift.
// That means you're removing the last bit from i.
// And shifting right by 1 is literally the same as doing i // 2.
// Example:

// Let’s say i = 13
// Binary: 1101
// i >> 1 → 110 → which is 6

// So:

//     countBits[13] = countBits[6] + 1

//     Why +1? Because 13 ends in 1 (check: 13 & 1 == 1)