t=int(input())
for i in range(t):
    n=int(input())
    a=set()
    for i in range(0,n):
        s=input()
        if(i==0):
            a=set(s)
        else:
            a=a.intersection(set(s))
    print(len(a))
