t=int(input())
for p in range(t):
    s=input()
    v=['a','e','i','o','u']
    s=list(filter(lambda x:x in v,s))
    print(len(s))
