class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        if len(strs)==1:return len(strs[0])
        c = 0
        for i in range(len(strs[0])):
            f = True
            for j in range(len(strs)-1):
                if strs[j][i]>strs[j+1][i]:
                    f = False
                    break
            if f == False:
                c+=1
        return c
