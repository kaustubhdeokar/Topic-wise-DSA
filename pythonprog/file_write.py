
f=open('read','r')
s=''
for i in f:
    a=i.index('//')
    i=i[:a]
    s+=i
    s+='\n'
f.close()
f1=open('write.txt','w')
for i in s:
    f1.write(i)
    
    
f1.close()
