n=int(input())
d={}
for i in range(n):
    arr=input()
    d[arr[0]]=arr[2:]
q=int(input())
d1={v:k for k,v in d.items()}
for i in range(q):
    s=input()
    print(d1[s])
    
    
