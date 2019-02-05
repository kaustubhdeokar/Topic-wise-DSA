from itertools import permutations

str1=input()
p=permutations(str1)
for i in p:
    print(''.join(i),end=' ')
