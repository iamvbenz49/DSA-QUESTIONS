class Solution:
    def isPalindrome(self, s: str) -> bool:
        lst = []
        for i in s:
            if i.isalnum():
                if i.isupper():
                    i = i.lower()
                lst.append(i)
        if lst == []:
            return True
        j,result,length = 0,0,len(lst)-1
        while j<=length+1//2:
            if lst[j]==lst[length]:
                j+=1
                length-=1
                result=1
                continue
            else:
                result=0
                return False
        if result == 1 :
                return True