for _ in range(int(input())):
    n,m=map(int,input().strip().split(' '))
    d={}
    for i in range(n):
        dish,value=map(int,input().strip().split(' '))
        if dish in d:
            if(value>d[dish]):
                d[dish]=value
        else:
            d[dish]=value
    d1=sorted(d,key=lambda x:d[x],reverse=True)
    s=d[d1[0]]+d[d1[1]]
    print(s)
