class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):return False
        dic = {}
        for i in range(len(s)):
            dic.setdefault(s[i],0)
            dic.setdefault(t[i],0)
            dic[s[i]]+=1
            dic[t[i]]-=1
        for i in dic:
            if dic[i]!=0:
                return False
        return True
