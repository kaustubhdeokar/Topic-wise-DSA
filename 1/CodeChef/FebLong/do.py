import math
t=int(input())
for i in range(t):
    n,a,b,k=list(map(int,input().strip().split(' ')))
    c=0
    if(a==b):
        print('Lose')
    else:            
        n1=n+1
        arr=[False]*n1
        for i in range(a,n1,a):
            arr[i]=not(arr[i])
        for j in range(b,n1,b):
            arr[j]=not(arr[j])
        c=arr.count(True)
        if(c>=k):
            print('Win')
        else:
            print('Lose')
        
