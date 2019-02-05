t=int(input())
for p in range(t):
    d={}
    s=input()
    set_s=set(s)
    for i in set_s:
        d[i]=s.count(i)
    a=1
    for i in d.values():
        a*=i
    print(a%(10**9+7))
