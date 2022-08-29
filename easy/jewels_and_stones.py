
#BRUTE FORCE
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        res = 0
        for i in jewels:
            for j in stones:
                if i == j:
                    res += 1
        return res
