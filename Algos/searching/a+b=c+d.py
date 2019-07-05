a=list(map(int,input().strip().split(' ')))
d={}
n=len(a)
ans=[]
for i in range(n):
    for j in range(i+1,n):
        if((a[i]+a[j]) in d):
            print((a[i],a[j]),(d[a[i]+a[j]][0],d[a[i]+a[j]][1]))
        d[a[i]+a[j]]=[a[i],a[j]]
