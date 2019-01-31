t=int(input())
for i in range(0,t):
    s=input()
    s=" "+s+" "
    t=s.find(" not ")
    if(t==-1):
    	print("regularly fancy")
    else:
    	print("Real Fancy")
