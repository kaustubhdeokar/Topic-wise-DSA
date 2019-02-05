from sys import stdin
t=1
for line in stdin:
    try:
        s=input()
        if(s==""):
            break
        try:
            i=s.index("//")
            s1=s[i:]
            s=s[:i]
            s=s.replace("->",'.')
        except:
            s=s.replace("->",'.')
            s1=''
        print(s+s1)
    except:
        
