for _ in range(int(input())):
    r,c,a = map(int,input().strip().split(' '))
    print((2+a)^(r+c+a))
