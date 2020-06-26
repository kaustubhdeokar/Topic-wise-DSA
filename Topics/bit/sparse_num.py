import math
for _ in range(int(input())):
    n=int(input())
    mask=3;
    k=math.ceil(math.log(n,2))-1;
    temp=0;
    for i in range(k):
        if((n & mask)==mask):
            temp=1;
            break;
        else:
            mask=mask<<1;
    if(temp==1):
        print(0);
    else:
        print(1);
