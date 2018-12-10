n=int(input())
arr=sorted(list(map(int,input().strip().split(' '))))
for i in range(1,n):
    if(arr[i]>arr[i-1]):
        arr[i-1]=0
    else:
        j=i-1
        while(j>-1):
            if(arr[j]!=0 and arr[i]-arr[j]>0):
                arr[j]=0
                break
            else:
                j-=1
print(sum(arr))
