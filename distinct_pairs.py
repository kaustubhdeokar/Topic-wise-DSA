n,m=map(int,input().strip().split(' '))
sum1=set()
t=n+m-1
temp=0
a=list(map(int,input().strip().split(' ')))
b=list(map(int,input().strip().split(' ')))
for i in range(0,n):
    for j in range(0,m):
        if((a[i]+b[j]) in sum1):
            pass
        else:
            sum1.add(a[i]+b[j])
            print(i,j)
            t-=1
            if(t==0):
                temp=1
                break
    if(temp==1):
        break
    
