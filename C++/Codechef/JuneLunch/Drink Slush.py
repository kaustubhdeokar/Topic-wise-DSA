for _ in range(int(input())):
    n,m=map(int,input().strip().split(' '))
    barrels=list(map(int,input().strip().split(' ')))
    dic={}
    for i in range(m):
        if(barrels[i]!=0):
            dic[i+1]=barrels[i]
    rem=[]
    profit=0
    answers=[0]*n
    gaps=[]
    
    for i in range(n):
        d,f,b=map(int,input().strip().split(' '))
        if(barrels[d-1]>0):
            profit+=f
            barrels[d-1]-=1
            dic[d]-=1
            answers[i]=d
            if(dic[d]==0):
                dic.pop(d)
        else:
            gaps.append(i)
            rem.append(b)
    l=len(gaps)
    arr=list(dic.keys())
    for i in range(l):
        if(d):
            counter=arr[0]
            if(dic[counter]>0):
                profit+=rem[i]
                answers[gaps[i]]=counter
                dic[counter]-=1
                if(dic[counter]==0):
                    dic.pop(counter)
                    arr=arr[1:]
        else:
            break
    print(profit)
    for i in answers:
        print(i,end=' ')
    
