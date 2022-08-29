class Solution:
    def nc2(self,n):
        return math.factorial(n)//(math.factorial(n-2)*(2))
    def numIdenticalPairs(self, nums: List[int]) -> int:
        map = {}
        res = 0
        for i in nums:
            if i in map:
                map[i]+=1
            else:
                map[i]=1
        for i in map:
            if map[i]>1:
                res = res + self.nc2(map[i])
        return res
