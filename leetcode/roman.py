def clumsy(n: int) -> int:
        arr=['*','/','+','-']
        i=0
        s=''
        while(n>0):
            s+=str(n)
            s+=arr[i%4]
            i+=1
        print(s)
        ans=round(eval(s))
        return ans
a=clumsy(10)
print(a)
