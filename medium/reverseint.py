x = -32

def reverse(x):
    if x>2**31 or x<-2**31:
        return 0
    x = str(x)
    x = [i for i in x]

    if "-"  in x:
        x.remove("-")
        x = x[::-1]
        x.insert(0,"-")
    else :
        x = x[::-1]
    x = "".join([i for i in x])
    x = int(x)
    print(x)
reverse(x)