n=int(input())
arr=list(map(int,input().strip().split(' ')))

s=sum(arr)
if(0 in arr):
    print('No')
else:
    if(s<(n*(n-1))):
        print('Yes')
    else:
        print('No')
