class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        lst = []
        for i in nums:
            res = 0
            for j in nums:
                if i>j:
                    res+=1
            lst.append(res)
        return lst
