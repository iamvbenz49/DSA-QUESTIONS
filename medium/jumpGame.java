class Solution:
    def canJump(self, nums: List[int]) -> bool:
        maxJump = 0
        for i in range(len(nums)):
            if i>maxJump:
                return False
            maxJump = maxJump if nums[i]+i<maxJump else nums[i]+i
        return True
