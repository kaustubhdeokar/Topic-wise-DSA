t=int(input())
for _ in range(t):
    temp=0
    n=int(input())
    arr=list(map(int,input().strip().split(' ')))
    maxi=arr[-1]
    mini=arr[-1]
    ele_in_right=1
    count=0
    temp=0
    for i in range(n-2,-1,-1):
        if(temp!=1):            
            if((arr[i]-(i+1))>2):
                print('Too chaotic')
                temp=1
                break
            elif(arr[i]>maxi):
                count+=ele_in_right
                maxi=arr[i]
                ele_in_right+=1
            elif(arr[i]<mini):
                mini=arr[i]
                ele_in_right+=1
            elif(arr[i]>mini and arr[i]<maxi):
                count+=len(list(filter(lambda x:x<arr[i],arr[i:])))
                ele_in_right+=1
    if(temp!=1):
        print(count)
