n,q=list(map(int,input().strip().split(' ')))
arr=list(map(int,input().strip().split(' ')))
for i in range(q):
    query=list(map(int,input().strip().split(' ')))
    if(query[0]):
        if(arr[query[1]-1]==0):
            arr[query[1]-1]=1
        else:
            arr[query[1]-1]=0
    else:
        if(arr[query[2]-1]==1):
            print('ODD')
        else:
            print('EVEN')
    
            
