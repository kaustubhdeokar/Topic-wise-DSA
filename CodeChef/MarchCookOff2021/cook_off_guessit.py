flush = 0
for _ in range(int(input())):
    for i in range(1,1000):
        print(i*i)
        flush = int(input())
        if(flush == 0):
            continue
        elif(flush == -1):
            break
        else:
            break
    
    if(flush == -1):
        break
    else:
        continue
        
