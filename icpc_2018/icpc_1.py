"""
Question1:
Two sisters, A and B, play the piano every day. During the day,
they can play in any order. That is, A might play first and then B,
or it could be B first and then A. But each one of them plays the
piano exactly once per day. They maintain a common log, in which they
write their name whenever they play. You are given the entries of the
log, but you're not sure if it has been tampered with or not. Your task
is to figure out whether these entries could be valid or not.
"""

t=int(input())
for i in range(t):
    s=input()
    l=len(s)
    ans=1
    for i in range(0,l,2):
        if(s[i]==s[i+1]):
            print('no')
            ans=0
            break
    if(ans==1):
        print('yes')
    
