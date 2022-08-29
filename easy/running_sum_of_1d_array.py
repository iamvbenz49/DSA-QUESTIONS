class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        sum = 0
        res = []
        for i in nums:
            sum+=i
            res.append(sum)
        return res
