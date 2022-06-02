""" 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3."""
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        limit = 2**31-1
        quotient = int(dividend/divisor)
        if quotient>limit:
            return limit
        elif quotient<(-limit):
            return -limit-1
        else:
            return quotient