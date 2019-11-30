t=int(input())
for p in range(t):
    t=0
    s=input()
    l=len(s)
    for i in range(l//2):
        if(s[i]!=s[l-i-1]):
            t=1
            break
    if(t==0):
      print('YES')
    else:
        print('NO')
