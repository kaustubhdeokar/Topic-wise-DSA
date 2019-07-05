#this program is to recursively remove the adjacent same character.

def condn(s):
    temp=1
    for i in range(len(s)-1):
        if(s[i]==s[i+1]):
            temp=0
            break
    if(temp==1):
        return True
    else:
        return False
def manip(s):
    ans=""
    for i in range(len(s)):
        if(i==0):
            if(s[i]!=s[i+1]):
                ans+=s[i]
        elif(i<len(s)-1):
            if(s[i]!=s[i+1] and s[i]!=s[i-1]):
                ans+=s[i]
        elif(i==(len(s)-1)):
            if(s[i]!=s[i-1]):
                ans+=s[i]
    return ans

s=input()   
while(not(condn(s))):
    s=manip(s)
print(s)
