class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        horizontalCuts.sort()
        verticalCuts.sort()
        return (self.area_calc(horizontalCuts,h)*self.area_calc(verticalCuts,w))%((10**9)+7)
    def area_calc(self,cuts,length):
        sums = 0
        for i in range(0,len(cuts)+1):
            if i == 0:
                sums = cuts[i]
            elif 0<i<len(cuts):
                if cuts[i]-cuts[i-1]>sums:
                    sums = cuts[i]-cuts[i-1] 
                else:
                    continue
            else:
                if length-cuts[i-1]>sums:
                    sums = length-cuts[i-1]
                    return sums
                else:
                    return sums
