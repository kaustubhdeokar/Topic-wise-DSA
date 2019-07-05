for _ in range(int(input())):
    n,m=map(int,input().strip().split(' '))
    arrn=list(map(int,input().strip().split(' ')))
    arrm=list(map(int,input().strip().split(' ')))
    
    d={}
    for i in arrn:
        try:
            d[i]+=1
        except:
            d[i]=1
    ans=[]
    for i in arrm:
        for j in range(d[i]):
            arrn.remove(i)
            ans.append(i)
    ans+=sorted(arrn)
    print(ans)
