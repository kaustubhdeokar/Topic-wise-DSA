t=int(input())
for z in range(t):
    d={}
    n,k=map(int,input().strip().split(' '))
    if(n<k):
        print(-1)
        continue
    arr=list(map(int,input().strip().split(' ')))
    for i in arr:
        if i not in d:
            c=arr.count(i)
            if(c>=k):
                d[i]=c
    if(d=={}):
        print(-1)
        continue
    sorted_d=sorted(d)
    min_pos=0
    for j in sorted_d:
        k=0
        c=0
        pos=0
        inc=0
        start=0
        while(c<d[j]):
            curr=arr[start:].index(j)
            if(c!=0):
                pos+=curr
            if(c==0):
                inc=curr+1
            else:
                inc+=curr+1
            start=inc
            c+=1
            print('curr is:{} pos:{} start:{} inc:{}'.format(curr,pos,start,inc))
        if(k==0):
            min_pos=pos
        else:
            if(min_pos>pos):
                min_pos=pos
        k+=1
    print(min_pos)
