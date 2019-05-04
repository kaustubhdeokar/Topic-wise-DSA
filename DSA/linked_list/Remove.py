t=int(input())
for j in range(t):
    n,k=map(int,input().strip().split(' '))
    arr=list(map(int,input().strip().split(' ')))
    d=0
    arr1=[]
    while(d<k):
        for i in range(n-1):
            if(arr[i]<arr[i+1] and d<k):
                arr1.append(arr[i])
                d+=1
        if(d<k):
            arr=list(set(arr)-set(arr1))
            n=len(arr)
            continue
        else:
            break
    print(list(filter(lambda x:x not in arr1,arr)))
            
