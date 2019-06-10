def sod(n):
    s=0
    while(n!=0):
        s+=n%10
        n//=10
    return s

if __name__=="__main__":
    a=10
    arr=[]
    for i in range(200):
        a+=9
        if(sod(a)%10==0):
            pass
        else:
            arr.append(i+1)
