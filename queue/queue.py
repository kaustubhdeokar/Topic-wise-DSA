import queue
q=queue.Queue()
n=int(input())
for i in range(n):
    s=input()
    if(s[0]=='E'):
        q.put(int(s[2:]))
        print(q.qsize())
    if(s[0]=='D'):
        if(q.qsize()>0):
            print(q.get(),end=" ")
            print(q.qsize())
        elif(q.qsize()==0):
            print(-1,end=" ")
            print(0)
    
