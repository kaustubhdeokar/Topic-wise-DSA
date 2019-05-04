n=int(input())
arr1=list(map(int,input().strip().split(' ')))
arr2=list(map(int,input().strip().split(' ')))
for i in range(n):
    print(arr1[i]+arr2[i],end=' ')
    
