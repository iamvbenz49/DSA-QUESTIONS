class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        character = upper_case = lower_case = digit = special_characters = 0
        symbols = "!","@","#","$","%","^","&","*","(",")","-","+"
        k = 0
        for i in password:
            character+=1
            if i.isalpha():
                if i.islower():
                    lower_case+=1
                elif i.isupper():
                    upper_case+=1
            elif i.isnumeric():
                digit+=1
            elif i in symbols:
                special_characters+=1
            if k == 1:
                if temp == i:
                    return False
            k=1
            temp = i
        if (character >= 8) and (upper_case >= 1) and (lower_case >= 1) and (digit >= 1) and (special_characters >=1) :
            return True
        else:
            return False
