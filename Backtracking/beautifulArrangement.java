class Solution {
    public int countArrangement(int n) {
        return backtrack(new int[n], 1, n);
    }
    public int backtrack(int[] vis, int number, int n) {
        if(number - 1 == n) {
            return 1;
        }
        int res = 0;
        for(int i = 1; i <= n; i++) {
            if(vis[i-1] == 0 && (number%i == 0 || i%number == 0)) {
                vis[i-1] = 1;
                res += backtrack(vis, number + 1, n);
                vis[i-1] = 0;
            }
        }
        return res;
    }
}

// 526. Beautiful Arrangement
// Solved
// Medium
// Topics
// Companies

// Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

//     perm[i] is divisible by i.
//     i is divisible by perm[i].

// Given an integer n, return the number of the beautiful arrangements that you can construct.

 

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: 
// The first beautiful arrangement is [1,2]:
//     - perm[1] = 1 is divisible by i = 1
//     - perm[2] = 2 is divisible by i = 2
// The second beautiful arrangement is [2,1]:
//     - perm[1] = 2 is divisible by i = 1
//     - i = 2 is divisible by perm[2] = 1

// Example 2:

// Input: n = 1
// Output: 1

 

// Constraints:

//     1 <= n <= 15

