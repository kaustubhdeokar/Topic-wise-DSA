t=int(input())
for i in range(t):
    n,k,v=map(int,input().strip().split(' '))
    arr=list(map(int,input().strip().split(' ')))
    t=n+k
    sum_nk=v*t
    sum_n=sum(arr)
    if(sum_nk<sum_n):
        print(-1)
    else:
        rem_sum=sum_nk-sum_n
        ans=rem_sum/k
        
        if(ans.is_integer()==True and ans!=0):
            print(int(ans))
        else:
            print(-1)
