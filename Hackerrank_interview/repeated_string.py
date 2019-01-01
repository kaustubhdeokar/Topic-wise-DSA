#!/bin/python3
import math
import os
import random
import re
import sys

# Complete the repeatedString function below.
def repeatedString(s, n):
    l=len(s)
    m=math.ceil(n/l)
    s=s*m
    s=s[:10]
    r=s.count('a')
    return r
if __name__ == '__main__':
    s = input()
    n = int(input())
    result = repeatedString(s, n)
    print(result)
