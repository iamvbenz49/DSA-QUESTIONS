class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if (n<1):
            return False
        return True if (math.log10(n)/math.log10(3))%1 == 0 else False
