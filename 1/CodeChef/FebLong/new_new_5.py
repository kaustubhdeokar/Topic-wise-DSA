import math
import sys
def divisors(a):
    arr=[]
    for i in range(2,a//2+1):
        if(a%i==0):
            arr.append(i)
    return arr

t=int(input())
for l in range(t):
    s=input().upper()
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
    if(math.floor(n)*dl<l and math.ceil(n)*dl>l):#not int,//float
        arr=[]
        arr=divisors(l)
        if(arr==[]):#prime all ones
            ans=min(list(map(lambda x:l-d[x],d)))
            print(ans)
        else:
            mini=sys.maxsize
            for i in arr:
                if(i-dl<mini):
                    mini=i
            to_add=mini-dl
            c=97
            if(to_add>0):
                for i in range(to_add):
                    d[chr(c)]=0
                    c+=1
                n=l//mini
                arr1=[]
                for i in d:
                    arr1.append(d[i]-n)
                ans=sum(list(filter(lambda x:x>0,arr1)))
                print(ans)
            else:
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
        
    
