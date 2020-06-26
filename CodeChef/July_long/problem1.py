for _ in range(int(input())):
    n=int(input())
    arr=list(map(int,input().strip().split(' ')))
    sumarr=sum(arr)
    mean=sumarr/n
    temp=0
    minrem=10**10
    minindex=10**3
    if(n==1):
        print('Impossible')
        continue
    for i in range(n):
        if((((sumarr-arr[i])/(n-1))==mean)and(arr[i]<minrem)):
            minrem=arr[i]
            minindex=i
            temp=1
    if(temp==0):
        print('Impossible')
    else:
        print(minindex+1)
