class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        res = 0
        for i in range(len(operations)):
            if (operations[i] == "++X" or operations[i] == "X++"):
                res+=1
            else:
                res-=1
        return res
