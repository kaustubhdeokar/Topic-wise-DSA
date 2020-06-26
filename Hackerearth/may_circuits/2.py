n,k=map(int,input().strip().split(' '))
arr=list(map(int,input().strip().split(' ')))
b=sorted(arr)
if(len(arr)&1==0):
    mid2=b[len(arr)//2]
    mid1=b[len(arr)//2-1]
    ans1=0
    ans2=0
    for i in range(len(b)):
        b[i]=abs(mid1-b[i])
    ans1=sum(b)
    b=sorted(b)
    for i in range(len(b)):
        b[i]=abs(mid2-b[i])
    ans2=sum(b)
    if(ans1<=ans2):
        print(arr.index(mid1)+1,end=' ')
        if(ans1-k)<0:
            print(abs(ans1-k)%2)
        else:
            print(ans1-k)
    else:
        print(arr.index(mid2)+1,end=' ')
        if(ans2-k)<0:
            print(abs(ans2-k)%2)
        else:
            print(ans2-k)
        
else:
        
    mid=b[len(arr)//2]
    for i in range(len(b)):
        b[i]=abs(mid-b[i])
    print(arr.index(mid)+1,end=' ')
    if (sum(b)-k)<0:
        print(abs(sum(b)-k)%2)
    else:
        print(sum(b)-k)
