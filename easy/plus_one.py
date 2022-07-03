class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        string = ""
        for i in range(len(digits)):
            string = string + str(digits[i])
        string = str(int(string)+1)
        digits = []
        for i in range(len(string)):
            digits.append(int(string[i]))
        return digits
