m=int(input())
n=int(input())
p=int(input())
q=int(input())

a=[]

def counteach(length,breadth):
    count=0
    temp=True
    while(temp):
        count+=1
        if(length<breadth):
            length,breadth=length,breadth-length
        elif(length>breadth):
            length,breadth=length-breadth,breadth
        elif(length==breadth):
            return count
        elif(length==1 and breadth==1):
            temp=False
    return count

for i in range(m,n+1):
    for j in range(p,q+1):
        a.append([i,j])

total=0
for i in a:
    total+=counteach(i[0],i[1])
print(total,end='')

