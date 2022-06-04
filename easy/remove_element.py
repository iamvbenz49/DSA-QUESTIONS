class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if nums == []:
            return 0
        elif val not in nums:
            return len(nums)
        low,high,res = 0,len(nums),0
        nums.sort()
        while True:
            mid = low + (high-low)//2
            if nums[mid] == val :
                break
            elif nums[mid]>val:
                high = mid
            elif nums[mid]<val:
                low = mid
        while True:
            if nums[mid] == val:
                nums.remove(val)
                nums.append("_")
                res+=1
            elif nums[mid]!= val:
                if nums[mid-1] == val:
                    nums.remove(val)
                    nums.append("_")
                    res+=1
                    mid-=1
                else:
                    return len(nums)-res