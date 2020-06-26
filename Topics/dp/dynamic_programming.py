factorial={}
def initdic():
    for i in range(10**2):
        factorial[i]=-1
def fact(n):
    if(n==1):
        return 1
    else:
        if(factorial[i]==-1):
            factorial[i]=n*fact(n-1)
            return factorial[i]
        
t=int(input())
initdic()
for i in range(t):
    n=int(input())
    print(fact(n))
