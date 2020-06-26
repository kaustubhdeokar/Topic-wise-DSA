import math
t=int(input())
for l in range(t):
    s=input()
    l=len(s)
    d={}
    dl=0
    for i in s:
        try:
            d[i]=d[i]+1
        except:
            d[i]=1
            dl+=1
    n=l/dl
    if(math.floor(n)*dl<l and math.ceil(n)*dl>l):#all ones
        c=0
        arr1=[]
        n=math.floor(n)
        for i in d:
            arr1.append(d[i]-n)
        c=sum(list(filter(lambda x:x>0,arr1)))
        print(c)
    else:
        arr=[]
        for i in d:
            arr.append(d[i]-n)
        c=sum(list(filter(lambda x:x>0,arr)))
        print(int(c))
        
    
