import sys
for i in sys.stdin:
    if(i=='\n' or ''):
        break
    n,m=list(map(int,i.strip().split(' ')))
    print(n^m)
