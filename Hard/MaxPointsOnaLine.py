class Solution:
    def maxPoints(self, p: List[List[int]]) -> int:
        dic ={"infinity":0}
        m = 0
        for i in range(len(p)-1):
            curr_max =0
            for j in range(i+1,len(p)):
                if p[i][0]-p[j][0]==0:
                    slope = "infinity"
                else:
                    slope = (float)(p[j][1]-p[i][1])/(float)(p[j][0]-p[i][0])
                if slope in dic:
                    dic[slope]+=1
                else:
                    dic[slope]=1
                curr_max = curr_max if curr_max>dic[slope] else dic[slope]
            dic.clear()
            m = m if m>curr_max else curr_max
        # max =0
        # for i in dic:
        #     if dic[i]>max:
        #         max = dic[i]
        print(dic)
        return m+1
