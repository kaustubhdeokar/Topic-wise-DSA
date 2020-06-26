#!/bin/python3

import sys


t = int(input().strip())
for a0 in range(t):
    fib=[1,2]
    n = 1+int(input().strip())
    i=fib[-1]
    while(i<n):
        i=fib[-1]+fib[-2]
        if(i<n):
            fib.append(i)
    fib = list(filter(lambda x: x &1==0, fib))
    print(sum(fib))
