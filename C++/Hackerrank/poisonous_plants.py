n=int(input())
arr=list(map(int,input().strip().split(' ')))
t=1
count=0
while(t):
    arr1=[]
    for i in range(1,n):
        if(arr[i]>arr[i-1]):
            arr1.append(i)
    if(arr1==[]):
        t=0
    else:
        count+=1
        arr1.reverse()
        for i in arr1:
            arr=arr[:i]+arr[i+1:]
        n=len(arr)
print(count)
