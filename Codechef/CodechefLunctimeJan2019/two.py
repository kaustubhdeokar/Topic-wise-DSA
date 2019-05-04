t=int(input())
for k in range(t):
    n,k=map(int,input().strip().split(' '))
    r=list(range(1,n+1))
    c=list(range(1,n+1))
    for i in range(k):
        r1,c1=map(int,input().strip().split(' '))
        r.remove(r1)
        c.remove(c1)
    print(n-k,end=' ')
    n1=n-k
    for i in range(n1):
        print(r[i],c[i],end=' ')
    print()
