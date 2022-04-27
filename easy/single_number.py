class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        lst_to_set = set(nums)

        for i in lst_to_set:
            res = nums.count(i)
            if res == 1:
                return i