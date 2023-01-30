class Solution:
    def tribonacci(self, n: int) -> int:
        memo = {0:0,1:1,2:1}
        def memoization(n):
            if n in memo:
                return memo[n]
            sum = memoization(n-1)+memoization(n-2)+memoization(n-3)
            memo[n] = sum
            return memo[n]
        return memoization(n) 
