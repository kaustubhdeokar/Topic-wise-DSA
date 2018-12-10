n=int(input())
arr=list(map(int,input().strip().split(' ')))
d={}
for i in set(arr):
    d[i]=arr.count(i)
q=int(input())
for j in range(q):
    m=int(input())
    try:
        print(d[m])
    except:
        print('NOT PRESENT')
        
