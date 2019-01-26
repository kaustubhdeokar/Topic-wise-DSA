n,t=map(int,input().strip().split(' '))
tup=[]
for i in range(n):
    s,n=map(str,input().strip().split(' '))
    tup.append([s,int(n)])
tup2=sorted(tup,key=lambda x:x[1],reverse=True)
for i in range(t):
    print(tup2[i][0])
