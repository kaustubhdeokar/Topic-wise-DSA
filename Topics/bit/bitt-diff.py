import math
for _ in range(int(input())):
    n,m=map(int,input().strip().split(' '))
    n1=math.ceil(math.log(n,2))
    m1=math.ceil(math.log(m,2))
    k=n1 if n1>m1 else m1
    mask=1
    diff=0
    for i in range(k):
        if((mask&n)!=(mask&m)):
            diff+=1
        mask=mask<<1
    print(diff)

