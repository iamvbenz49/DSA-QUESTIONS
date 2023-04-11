class Solution:
    def removeStars(self, s: str) -> str:
        r = ""
        c = 0
        for i in s[::-1]:
            if i=='*':
                c+=1
            elif c!=0:
                c-=1
            else:
                r = i + r
        return r
