def attendance(present,total):
    return ((present/total)*100)>=75
def check(s,i):
    if((s[i]=="A")and(s[i-1]=="P" or s[i-2]=="P")and(s[i+1]=="P" or s[i+2]=="P")):
        return True
        
    
t=int(input())
for _ in range(t):
    total=int(input())
    s=input()
    ans=0
    absent=s.count("A")
    present=total-absent
    if(attendance(present,total)):
        print(0)
        continue
    elif(total<=4):
        print(-1)
    else:
        temp=0
        for i in range(2,total-2):
            if(check(s,i)):
                ans+=1
            if(attendance(present+ans,total)):
                print(ans)
                temp=1
                break
    
        if(temp!=1):
            print(-1)

