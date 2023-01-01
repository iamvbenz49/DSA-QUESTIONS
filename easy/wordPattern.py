class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        dic = {}
        s = s.split()
        if len(s)!=len(pattern):
            return False
        for i in range(len(s)):
            if pattern[i] in dic:
                if dic[pattern[i]] != s[i]:
                    return False
            else:
                if s[i] in dic.values():
                    return False
                dic[pattern[i]] = s[i]
        return True
