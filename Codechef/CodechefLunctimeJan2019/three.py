t=int(input())
for z in range(t):
    n=int(input())
    a=[]
    b=[]
    arr1=list(map(int,input().strip().split(' ')))
    arr2=list(map(int,input().strip().split(' ')))
    for i in range(n):
        a.append([arr1[i]])
        if(i!=0):
            a[0].append(arr1[i])
    arr2.reverse()
    for j in range(n):
        b.append([arr2[j]])
        if(j!=0):
            b[0].append(arr2[j])
    b[0].reverse()
    print(a)
    b.reverse()
    print(b)
