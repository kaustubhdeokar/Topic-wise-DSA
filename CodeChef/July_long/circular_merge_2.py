import sys
for _ in range(int(input())):
    n1=int(input())
    A=list(map(int,input().split()))
    penalty=0
    while len(A)>1:
        sum=sys.maxsize
        for i in range(len(A)):
            if A[i]+A[(i+1)%len(A)]<sum:
                sum=A[i]+A[(i+1)%len(A)]
                j=i
        A.insert(j,sum)
        penalty+=sum
        A.remove(A[j+1])
        A.remove(A[(j+1)%len(A)])
        
    print(penalty)
