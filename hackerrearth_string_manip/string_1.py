t=int(input())
for l in range(t):
    s,a,b=list(map(str,input().strip().split(' ')))
    a,b=int(a),int(b)
    print(s[:a]+''.join(sorted(s[a:b+1],reverse=True))+s[b+1:])
    
