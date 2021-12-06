modulo = 10**9+7
for _ in range(int(input())):
    n = int(input())
    arr = sorted(list(map(int,input().strip().split(' '))),reverse=True)
    for i in range(n):
        arr[i]=arr[i]-i
    arr = list(filter(lambda x:x>0,arr))
    total = 0
    for i in arr:
        total += (i%modulo)
    print(total%modulo)
