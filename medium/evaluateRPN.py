class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        ls = []
        for i in tokens:
            if i.isnumeric() or (len(i)>1 and i[0] == "-"):
                ls.append(int(i))
            else:
                a = int(ls.pop())
                b = int(ls.pop())
                if i == "+":
                    ls.append(int(a+b))
                elif i == "-":
                    ls.append(int(b-a))
                elif i == "*":
                    ls.append(int(a*b))
                else:
                    ls.append(int(float(b)/a))
        return ls[0]
