class Solution:
    def minimumSum(self, num: int) -> int:
        res = sorted([int(i) for i in str(num)])
        return ((res[0]*10)+res[2])+((res[1]*10)+res[3])
