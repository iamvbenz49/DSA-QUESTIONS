"""
Input: num1 = "2", num2 = "3"
Output: "6"
"""

num1 = "2"
num2 = "3"
def sum(n1,n2):
    n1,n2 = int(n1),int(n2)
    return str(n1*n2)
s = sum(num1,num2)
print(s)