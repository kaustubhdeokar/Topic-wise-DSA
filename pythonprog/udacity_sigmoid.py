import math

def sigmoid(x):
    if 1/(1+math.exp(-x)) == 0.5:
        print("true")
    else:
        print("not true")

def calculate(a,b):
    sigmoid(4*a+5*b-9)

a=[[1,1],[2,4],[5,-5],[-4,5]]
for i in a:
    calculate(i[0],i[1])
