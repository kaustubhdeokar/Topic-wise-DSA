s=list(map(str,input().strip().split(' ')))
max_arr=0
len_max_arr=0
for i in s:
    if(len(i)%2==0 and len(i)>len_max_arr):
        max_arr=i
        len_max_arr=len(i)
print(max_arr)
