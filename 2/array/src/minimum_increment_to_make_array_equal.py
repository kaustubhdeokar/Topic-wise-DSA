#a = [4, 7, 19, 16]
#a = [i+1 for i in a]
a= [4, 4, 4, 4]
k = 3

remainder = a[0]%k
total_sum = a[0]

for i in range(1,len(a)):
    total_sum+=a[i]
    if(remainder!=a[i]%k):
        print('not possible')
   
average = total_sum//len(a)
print('array:'+str(a))
print('average:'+str(average)+' total_sum:'+str(total_sum))

closest_values = []
if(average%k==remainder):
    closest_values.append(average)
if((average-remainder-a[0])%k==0):
    closest_values.append(average-remainder)
if((average+remainder-a[0])%k==0):
    closest_values.append(average+remainder)

print('closest_values'+str(closest_values))

counts_to_closest_values = [0]*len(closest_values)

for i in range(0, len(a)):
    for j in range(0, len(closest_values)):
        counts_to_closest_values[j]+=abs(closest_values[j]-a[i])//k
    print(counts_to_closest_values)

print('minimum increments:'+str(min(counts_to_closest_values)))
