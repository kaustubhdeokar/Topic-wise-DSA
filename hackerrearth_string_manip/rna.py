t=int(input())
for p in range(t):
    d={'A':'T' , 'T':'A','C':'G','G':'C'}
    n=int(input())
    s=input()
    ans=''
    t=0
    for i in s:
        try:
            ans+=d[i]
        except:
            t=1
            break
    if(t==1):
            print('Error RNA nucleobases found!')
    else:
        print(ans)




