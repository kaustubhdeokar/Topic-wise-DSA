from sys import stdin
t=1
while(t):
    s=input()
    try:
        q=s.index("return")
        print(s)
        t=0
    except:
        i=s.index("//")
        p=s[i:]
        s=s[:i]
        s=s.replace("->",".")
        print(s+p)
    else:
        s=1
