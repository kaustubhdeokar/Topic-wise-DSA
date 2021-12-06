def sod(n):
    s=0
    while(n!=0):
        s+=n%10
        n//=10
    return s

if __name__=="__main__":
    t=int(input())
    for _ in range(t):
        a=190
        n=int(input())
        units=sod(n)
        if(units%10==0):
            print(n*10)
        else:
            req=10-(units%10)
            print(n*10+req)

