"""
You are given an array with N integers: A[1],A[2],…,A[N]
(where N is even). You are allowed to permute the elements
however you want. Say, after permuting the elements, you end up
with the array A′[1],A′[2],…,A′[N]. Your goal is to maximize the
following sum:

|A′[1]−A′[2]| + |A′[3]−A′[4]| + ... + |A′[N−1]−A′[N]|
Here, |x| denotes the absolute value of x.

You have to print the maximum sum achievable.

"""



t=int(input())
for i in range(t):
    n=int(input())
    arr=sorted(list(map(int,input().strip().split(' '))))
    total=0
    n1=n-1
    for i in range(n//2):
        total+=abs(arr[i]-arr[n1-i])
    print(total)
    
