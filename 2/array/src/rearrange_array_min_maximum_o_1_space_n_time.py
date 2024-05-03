##rearrange array -> O(1) space and O(n) time

arr = [1,2,3,4,5]
required_output = [5,1,4,2,3] #max_min_format
## required output format -> is one from last, one from first.

max_idx = len(arr)-1
min_idx = 0
multiplier = 9 # any number greater than max elem of array

for i in range(0,len(arr)):
    if i%2==0:              ## even positions - max elements
        arr[i]+=arr[max_idx]%multiplier*multiplier
        max_idx-=1
    else:                   ##odd positions  - min elements 
        arr[i] += arr[min_idx]%multiplier*multiplier
        min_idx+=1    
print(arr)

for i in range(0,len(arr)):
    arr[i]//=multiplier

print(arr)


"""
logic: purpose of this expression is to store two elements as at index.

How does expression “arr[i] += arr[max_index] % max_element * max_element” work ? 
The purpose of this expression is to store two elements at index arr[i].
arr[max_index] is stored as multiplier and “arr[i]” is stored as remainder.
For example in {1 2 3 4 5 6 7 8 9}, max_element is 10 and we store 91 at index 0. With 91, we can get original element as 91%10 and new element as 91/10.


"""
