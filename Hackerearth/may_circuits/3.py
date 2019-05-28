n=int(input())
start=list(map(int,input().strip().split(' ')))
end=list(map(int,input().strip().split(' ')))
zipped=list(zip(start,end))
z=sorted(zipped,key=lambda x:x[0])

parent=[0]

for i in range(1,n):
    counter=i
    if(z[i][0]>=z[i-1][0] and z[i][1]<=z[i-1][1]):
        parent.append(counter)
    else:
        while(counter>=0):
            if(z[i][0]>=z[counter-1][0] and z[i][1]<=z[counter-1][1]):
                break
            else:
                counter-=1
                continue
        parent.append(counter)

parentindex=[-1]
for i in range(1,n):
    k=parent[i]
    counter=i-1
    #k=1
    while(counter>=0):
        if(parent[counter]==k-1):
            parentindex.append(counter)
            break
        else:
            counter-=1
            continue

finalans=[0]*5
for i in range(1,n):
    finalans[zipped.index(z[i])]=zipped.index(z[parentindex[i]])
for i in range(len(finalans)):
    if(finalans[i]!=0):
        finalans[i]+=1
    else:
        pass
for i in finalans:
    print(i,end=' ')
