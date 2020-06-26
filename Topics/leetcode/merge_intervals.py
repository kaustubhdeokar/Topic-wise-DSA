    
arr=list(map(int,input().strip().split(' ')))
arr=arr[1:]
t=[]
for i in range(len(arr)//2):
    sub=arr[:2]
    arr=arr[2:]
    t.append(sub)
arr=sorted(t,key=lambda x:x[0])
count=len(arr)-1
i=0
index=0
while(i<count):
    if(len(arr)>1 and arr[index][1]>=arr[index+1][0]):
        start=min(arr[index][0],arr[index+1][0])
        end=max(arr[index][1],arr[index+1][1])
        arr[index:index+2]=[[start,end]]
    else:
        index+=1
        if(index+2>count):
            break
        i+=1
    print(arr)
print(arr)
