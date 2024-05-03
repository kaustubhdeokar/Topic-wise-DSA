# To find: majority element. 
# A majority element in an array A[] of size n is an element that appears more
# than n/2 times (and hence there is at most one such element).

a = [3, 3, 4, 2, 4, 4, 2, 4, 4]
curr_elem = -1
count = 0

for i in range(0, len(a)):
    if(a[i]==curr_elem):
        count+=1
    elif(count>0 and a[i]!=curr_elem):
        count-=1
    elif(count==0 and a[i]!=curr_elem):
        curr_elem = a[i]
        count+=1
    print('curr_elem:'+str(curr_elem)+' count:'+str(count))
        
if(a.count(curr_elem)>=(len(a)/2)):
    print('majority element'+str(curr_elem))
else:
    print('no majority element')
