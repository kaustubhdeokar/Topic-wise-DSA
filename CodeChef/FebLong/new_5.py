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
            #print('all prime')
            k=list(d.values())
            mini=min(k)
            count_of_sum=0
            sum_except_min=0
            for i in k:
                if(i!=mini):
                    sum_except_min+=i
                    count_of_sum+=1
            n=sum_except_min//count_of_sum
            ans=[]
            for i in k:
                if(i!=mini):
                    ans.append(n-mini)
            print(sum(ans))
        else:
            mini=sys.maxsize
            for i in arr:
                if(i-dl<mini):
                    mini=i
            to_add=mini-dl
            c=97
            if(to_add>0):
                #print('to add+')
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
                #print('to add+')
                n=l//mini
                arr2=[]
                d1=sorted(d.items(),key=lambda x:x[1])
                for i in range(abs(to_add)):
                    d[d1[1][0]]+=1
                    del(d[d1[0][0]])
                for i in d:
                    arr2.append(d[i]-n)
                ans=sum(list(filter(lambda x:x>0,arr2)))
                print(ans+1)
    else:
        #print('proper div')
        arr=[]
        for i in d:
            arr.append(d[i]-n)
        c=sum(list(filter(lambda x:x>0,arr)))
        print(int(c))
        
    
