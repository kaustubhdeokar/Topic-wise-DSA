#!/bin/python3
import math
import os
import random
import re
import sys

# Complete the repeatedString function below.
def repeatedString(s, n):
    toret=0
    a_in_s=s.count('a')
    l=len(s)
    m=((a_in_s/l)*n)
    toret+=m
    n=n%l
    s=s[:n]
    a_in_s=s.count('a')
    toret+=a_in_s
    return toret
if __name__ == '__main__':
    s = input()
    n = int(input())
    result = repeatedString(s, n)
    print(result)
