from math import ceil
d1,v1,d2,v2,required = list(map(int,input().strip().split(' ')))
i=1
produced=0
while(produced<required):
    if(i>=d1):
        produced+=v1
    if(i>=d2):
        produced+=v2
    i+=1
print(i-1)
