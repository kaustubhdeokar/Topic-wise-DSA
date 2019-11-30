t=int(input())
for _ in range(t):
    n=int(input())
    k=int(input())
    k=(k%n) 
    if(k==0):
        print(0)
    elif(k==(n//2)):
        if(n%2==0):
            print(2*k-1)
        else:
            print(2*k)
    elif(k<2*k)):
        print(k*2)
    else:
        print((n-k)*2)

