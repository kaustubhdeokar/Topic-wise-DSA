for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().strip().split(' ')))
    ans=0
    while(n>1):
        p=a.index(min(a))
        temp=0
        if(p==0):
            minnum=a[(p+1)%n]
            temp=p+1
            if(a[n-1]<minnum):
                minnum=a[n-1]
                temp=n-1
            a[p]+=minnum
            ans+=a[p]
            del(a[temp])
        else:
            minnum=a[(p+1)%n]
            temp=((p+1)%n)
            if(a[p-1]<minnum):
                temp=p-1
                minnum=a[temp]
            a[p]+=minnum
            ans+=a[p]
            del(a[temp])
        n-=1
    print(ans)
        
