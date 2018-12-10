def count(s):
    returncount=0
    for i in range(len(s)):
        if s[i]=='p':
            returncount+=s[:i].count('c')
        if s[i]=='c':
            returncount+=s[i:].count('p')
    return returncount

s=input()
if(len(set(s))==1):
    print(0)
elif(s.rindex('p')<s.index('c')):
    print(0)
else:
    leftc=s.index('c')
    rightp=s.rindex('p')
    s=s[:leftc]+'p'+s[leftc+1:]
    s=s[:rightp]+'c'+s[rightp+1:]
    a=count(s)
    print(a)
    
