def gcd(a,b):
    if(b==0):
        return a
    else:
        return gcd(b,a%b)


for _ in range(int(input())):
    n=int(input())
    arr=list(map(int,input().strip().split(' ')))
    arr=list(set(arr))
    n=len(arr)
    if(n==1):
        print(arr[0]+arr[0])
    elif(n==2):
        print(arr[0]+arr[1])
    else:    
        m=max(arr)
        mindex=arr.index(m)
        sm=0
        smindex=0
        for i in range(n):
            if(arr[i]>sm and arr[i]<m):
                sm=arr[i]
                smindex=i
##        a=gcd()+m
##        b=gcd()+sm
##        
        temp1=arr[:smindex]+arr[smindex+1:]
        temp2=arr[:mindex]+arr[mindex+1:]
        total1=gcd(temp1[0],temp1[1])
        total2=gcd(temp2[0],temp2[1])

        for i in range(2,n):
            try:
                total1=gcd(total1,temp1[i])
            except:
                pass
        ans1=total1+sm

        for i in range(2,n):
            try:
                total2=gcd(total2,temp2[i])
            except:
                pass
        ans2=total2+m

        if(ans1>ans2):
            print(ans1)
        else:
            print(ans2)

