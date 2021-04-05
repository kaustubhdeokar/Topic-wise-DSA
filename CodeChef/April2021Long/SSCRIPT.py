for _ in range(int(input())):
    string_length,pattern_length = map(int,input().strip().split(' '))
    string = input()
    count = 0
    for i in range(string_length):
        if(string[i]!='*'):
            count = 0 
        else:
            count+=1

        if(count==pattern_length):
            break
    if(count==pattern_length):
        print('YES')
    else:
        print('NO')
