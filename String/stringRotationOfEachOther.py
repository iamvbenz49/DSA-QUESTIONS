class Solution:
    
    #Function to check if two strings are rotations of each other or not.
    def areRotations(self,s1,s2):
        #code here
        def kmp(s, p):
            s = p + "$" + s
            lps = [0]*len(s)
            index = 1
            while index < len(s):
                prev_index = lps[index - 1]
                while prev_index > 0 and s[prev_index] != s[index]:
                    prev_index = lps[prev_index - 1]
                if s[prev_index] == s[index]:
                    lps[index] = prev_index + 1
                if index > len(p) and lps[index] == len(p):
                    return True
                index += 1
            return False
        return kmp(s1 + s1, s2)