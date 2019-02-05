a=input()
b=input()
if(a==b):
    print('YES')
else:
    len_a=len(a)
    len_b=len(b)
    if(len_a!=len_b):
        print('NO')
    else:
        a_ord=[ord(i) for i in a]
        b_ord=[ord(i) for i in b]
        for i in range(len_a):
            t=0
            if(a_ord[i]>b_ord[i]):
                t=1
                break
        if(t==1):
            print('NO')
        else:
            print('YES')
