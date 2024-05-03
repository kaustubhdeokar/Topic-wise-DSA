arr = [1,2,3,4,5,6,7]
d = 2
output_req = [3, 4, 5, 6, 7, 1, 2]
multiplier = max(arr)+1
rotate_idx = d

starting_idx = 0
for i in range(len(arr)-d, len(arr)):
    arr[i] += (arr[starting_idx]%multiplier)*multiplier
    starting_idx+=1

for i in range(0,len(arr)-d):
    arr[i]+=arr[rotate_idx]%multiplier*multiplier
    rotate_idx+=1

for i in range(0,len(arr)):
    arr[i] = arr[i]//multiplier
    
