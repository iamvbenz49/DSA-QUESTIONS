class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l = len(numbers)
        for i in range(l):
            res = target - numbers[i]
            crossed = [i]
            low,high = 0,l-1
            while True:
                mid = low + (high-low)//2
                if mid in crossed:
                    break
                if numbers[mid] == res:
                    end = [i+1,mid+1]
                    if end[0]>end[1]:
                        end[0],end[1] = end[1],end[0]
                    return end
                elif numbers[mid]<res:
                    low = mid
                    crossed.append(mid)
                elif numbers[mid]>res:
                    high = mid
                    crossed.append(mid)
                elif mid == 0 | mid == len(num)-1:
                    break
