class Solution:
    def addDigits(self, num: int) -> int:
        while True:
            ans = sum(map(int,list(str(num).strip(" "))))
            if ans<10:
                return ans
            num = ans
