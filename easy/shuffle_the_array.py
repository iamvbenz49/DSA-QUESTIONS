class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        length = len(nums)//2
        res = []
        for i in range(length):
            res.extend([nums[i],nums[length+i]])
        return res
