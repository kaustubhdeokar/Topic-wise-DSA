import os
import sys

def pageCount(n, p):
    print('odd')
    if(n==p):
        return 0
    if(n&1):
        n-=1
        a=(n-p)//2
        print(a)
        b=p//2
        print(b)
        if(a>b):
            return(b)
        else:
            return(a)
    else:
        if(p==n-1):
            return 1
        a=(n-p)//2
        b=p//2
        if(a>b):
            return(b)
        else:
            return(a)
if __name__ == '__main__':

    n = int(input())

    p = int(input())

    result = pageCount(n, p)
    print(result)
