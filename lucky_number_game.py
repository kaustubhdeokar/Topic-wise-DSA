t=int(input())
for i in range(t):
    n,a,b=list(map(int,input().strip().split(' ')))
    arr=list(map(int,input().strip().split(' ')))
    counta=0
    countb=0
    countc=0
    t1=False
    if(a==b):
        print('BOB')
    else:
        for i in range(0,n):
            if(arr[i]%a==0 and arr[i]%b==0):
                t1=True
            elif(arr[i]%a==0):
                counta+=1
            elif(arr[i]%b==0):
                countb+=1
        if(t1):
            
