t=int(input())
for i in range(t):
    n=int(input())
    a=set()
    for j in range(n):
        x,y=map(int,input().strip().split(' '))
        a.add(x)
        a.add(y)
    print(len(a))
