for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().strip().split(' ')))
    personsQueue = []
    for i in range(n):
        if(arr[i] == 1):
            personsQueue.append(i+1)
    answer = True
    for i in range(len(personsQueue)-1):
        if((personsQueue[i+1]-personsQueue[i])<6):
            answer = False
            break
    if(answer):
        print("YES")
    else:
        print("NO")
