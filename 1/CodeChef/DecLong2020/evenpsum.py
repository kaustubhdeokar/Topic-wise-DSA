t=int(input())
while(t>0):
    a,b=map(int,input().strip().split(' '))
    total=0
    if(a&1==1 and b&1==1):#both odd.
        total+=(a//2)*b+(b//2+1)
    else:
        total+=(a*b)//2
    print(total)
    t-=1
