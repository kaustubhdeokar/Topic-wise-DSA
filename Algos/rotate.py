def leftrotate(n,t):
    return (n<<t) | (n>>(15-t))
def rightrotate(n,t):
    return (n>>t) | (n<<(15 -t))
        
for _ in range(int(input())):
    n,t=map(int,input().strip().split(' '))
    print(leftrotate(n,t))
    print(rightrotate(n,t))
