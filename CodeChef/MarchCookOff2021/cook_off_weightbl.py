for _ in range(int(input())):
    w1,w2,x1,x2,m = map(int,input().strip().split(' '))
    weight_diff = w2-w1
    min_weight = x1*m
    max_weight = x2*m

    if(weight_diff>= min_weight and weight_diff <= max_weight):
        print(1)
    else:
        print(0)
