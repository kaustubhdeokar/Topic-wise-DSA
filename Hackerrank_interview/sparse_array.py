arr1=[]
arr2=[]
for i in range(int(input())):
    arr1.append(input())
for j in range(int(input())):
    arr2.append(input())
for i in arr2:
    print(arr1.count(i))
