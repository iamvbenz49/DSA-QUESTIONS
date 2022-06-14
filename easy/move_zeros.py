class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        ans = 0
        for i in nums:
            if i == 0:
                ans+=1
        for i in range(ans):
            nums.remove(0)
        for i in range(ans):
            nums.append(0)
