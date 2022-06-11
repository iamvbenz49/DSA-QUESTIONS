class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        needle_l = len(needle)
        haystack_l = len(haystack)
        for i in range(haystack_l) :
            if haystack[i:i+needle_l] == needle :
                return i
        else:
            return -1
