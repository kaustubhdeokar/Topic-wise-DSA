def gcd(a,b): 
    if (a == b): 
        return a 
    if (a > b): 
        return gcd(a-b, b)
    return gcd(a, b-a) 
def lcm(a,b): 
    return (a*b) / gcd(a,b) 
t=int(input())
for i in range(t):
    n,a,b,k=list(map(int,input().strip().split(' ')))
    p=n//a+n//b-((n/lcm(a,b))*2)
    if(a==b):
        print("Lose")
    elif(p>=k):
        print("Win")
    else:
        print("Lose")
        
