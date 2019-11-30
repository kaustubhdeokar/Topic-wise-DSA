t=int(input())
for i in range(t):
    a=int(input())
    sum_a=a
    sum_pow=1
    max_pow=0
    i=1
    max_i=i
    while(sum_a>sum_pow):
        sub=sum_a-sum_pow
        if(max_pow<sub):
            max_pow=sub
            max_i=i
        sum_a+=a
        increment=1<<i
        sum_pow+=increment
        i+=1
    print(i-1,max_i)
