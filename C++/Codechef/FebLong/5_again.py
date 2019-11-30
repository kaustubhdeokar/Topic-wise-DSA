import math
def create_dict(s):
    d={}
    for i in s:
        try:
            d[i]+=1
        except:
            d[i]=1
    return d

t=int(input())
while(t):
    s=input()
    d={}
    d=create_dict(s)
    d_values=list(d.values())
    d1={}
    for i in d_values:
        try:
            d1[i]+=1
        except:
            d1[i]=1
    
    sum_d_values=sum(d_values)
    l=len(d)
    average=int(sum_d_values/l)
    #case 1 =no change
    if(int(average)*l==sum_d_values):
        print(0)
    #case 2
    else:
        round_average=math.floor(average)
        print('round_average_is{}'.format(round_average))
        arr=[]
        for i in d_values:
            arr.append(abs(i-round_average))
        print(sum(arr))
    print(d1)    
    t-=1
