for _ in range(int(input())):
    k1,k2,k3,v = map(float,input().strip().split(' '))
    finalspeed =  k1*k2*k3*v 
    time = round(100/finalspeed,2)
    if(time<9.58):
        print('YES')
    else:
        print('NO')
    
