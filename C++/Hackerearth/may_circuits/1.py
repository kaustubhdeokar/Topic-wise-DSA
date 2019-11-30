for i in range(int(input())):
    s=input()
    l1=list(set(s))
    l2=[]
    for i in l1:
        l2.append(s.count(i))
    c=0
    for i in l2:
        if i%2==1:
            c+=1
    if len(s)%2==0 and c==2:
        print("DPS")
    elif len(s)%2==1 and (c==1 or c==3):
        print("DPS")
    else:
      print("!DPS")
