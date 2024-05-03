arr = [10, 5, 20, 40]
update_arr = [0]*len(arr)


## below array - helps us to perform updates in O(1) time.
def update(start, end, incr):
    update_arr[start]+=incr
    if end!=(len(arr)-1):
        update_arr[end+1]-=incr


update(0, 1, 10)
update(1, 3, 20)
## for the above range , we do update[1]+=20 and update[3+1]-=20 -> and later use this in a prefix sum.
update(2, 2, 30)

#hence all updates are performed in O(1) time.

prefix = 0
for i in range(0, len(update_arr)):
    update_arr[i] = prefix + update_arr[i]
    prefix = update_arr[i]

for i in range(0, len(arr)):
	arr[i] += update_arr[i]

print(arr)
