t=int(input())
for l in range(t):
    n=int(input())
    arr=list(map(int,input().strip().split(' ')))
    m=0
    for i in arr:
        m+=i-1
    print(m+1)
    
    
