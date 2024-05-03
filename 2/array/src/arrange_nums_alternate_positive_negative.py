#arr = [-1, 2, -3, 4, 5, 6, -7, 8, 9]
arr = [-1, 3, -2, -4, 7, -5]
pos_idx = 0
neg_idx = 0

        
def swap(arr, idx, curr):
    temp = arr[idx]
    arr[idx] = arr[curr]
    arr[curr] = temp

for i in range(0,len(arr)):
    if i%2==0:
        while pos_idx<len(arr) and arr[pos_idx]<0:
            pos_idx+=1
        if pos_idx<len(arr):
            swap(arr, pos_idx, i)
        pos_idx+=1
    else:
        while neg_idx<len(arr) and arr[neg_idx]>0:
            neg_idx +=1
        if neg_idx < len(arr):
            swap(arr, neg_idx, i)
        neg_idx +=1
    print(arr)
    
