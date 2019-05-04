#!/bin/python3

import sys


t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    n3=(n-1)//3
    n5=(n-1)//5
    n15=(n-1)//15
    total=(n3*(6+(n3-1)*3))+(n5*(10+(n5-1)*5))-(n15*(30+(n15-1)*15))
    print(total//2)
