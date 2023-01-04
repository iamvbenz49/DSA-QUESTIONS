class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        dic = {}
        for i in tasks:
            if i in dic:
                dic[i]+=1
            else:
                dic[i]=1
        c = 0
        for i in dic.values():
            if i%3==0:c+=i//3
            elif i==2:c+=1
            elif i%3<=2 and i!=1:c+=i//3+1
            else:return -1
        return c
