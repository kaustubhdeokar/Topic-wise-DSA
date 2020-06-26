t=int(input())
for z in range(t):
    n=int(input())
    s=input()
    c1=s.count('1')
    c=0
    if(n==1):
        if(s[0]=='1'):
            print(0)
        else:
            print(1)
        break
    
    for i in range(n):
        if(i==0):
            if(s[i+1]=='0'):
                s='1'+s[1:]
                c+=1
        elif(i<n-1):
            if(s[i-1]=='0' and s[i+1]=='0' and s[i]=='0'):
                s=s[:i]+'1'+s[i+1:]
                c+=1
        else:
            if(s[i-1]=='0' and s[i]=='0'):
                c+=1
                s=s[:i]+'1'
    print(c)
            
            
