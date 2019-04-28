t=int(input())
for i in range(t):
    a=input()
    b=input()
    d_a={}
    d_b={}
    for i in set(a):
        d_a[i]=a.count(i)
    for i in set(b):
        d_b[i]=b.count(i)
    s=set(d_a).intersection(set(d_b))
    total=0    
    for i in d_a:
        if(i not in s):
            total+=d_a[i]
    for i in d_b:
        if(i not in s):
            total+=d_b[i]
    for i in s:
        total+=abs(d_a[i]-d_b[i])
    print(total)

