t=int(input())
for i in range(t):
    n,a,b,k=list(map(int,input().strip().split(' ')))
    count=0
    arr=list(range(1,n+1))
    for i in arr:
        if((i%a==0 and i%b!=0) or(i%a!=0 and i%b==0)):
            count+=1
    if(count>=k):
        print('Win')
    else:
        print('Lose')
    
    
