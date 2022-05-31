"""Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result."""
class Solution:
    def myAtoi(self, s: str) -> int:
        lst = ["1","2","3","4","5","6","7","8","9","0"]
        symbols = ["+","-"]
        res = ""
        count = 0
        for i in s:
            if i == " ":
                count+=1
                continue
            else:
                break
        for i in range(count,len(s)):
            if s[i] in symbols:
                res+=s[i]
                count+=1
                break
            elif s[i] in lst:
                res+=s[i]
                count+=1
                break
            elif s[i] not in lst:
                return 0
        for i in range(count,len(s)):
            if s[i] in lst:
                res+=s[i]
            elif s[i] not  in lst:
                break
        if len(res) == 1 and res[0] in symbols:
            return 0
        elif res == "":
            return 0
        elif " " in res:
            return 0
        elif int(res)>2**31-1 :
            return 2147483647
        elif int(res)<-2**31:
            return -2147483648
        
        return int(res)
            

