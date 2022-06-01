
s = "[([]])"
print(s[-1])
def func():
    stack=[]
    open = ["(","{","["]
    close = [")","}","]"]
    lenght = len(s)
    if lenght%2==1:
        return False
    for i in range(0,lenght):
        if s[i] in open:
            stack.append(s[i])
        elif s[i] in close:
            if stack == []:
                return False
            elif s[i] == ")" and stack[-1] == "(":
                stack.pop(len(stack)-1)
            elif s[i] == "]" and stack[-1]=="[":
                stack.pop(len(stack)-1)
            elif s[i] == "}" and stack[-1]=="{":
                stack.pop(len(stack)-1)
            else:
                return False
    if stack==[]:
        return True
    else:
        return False
print(func())
