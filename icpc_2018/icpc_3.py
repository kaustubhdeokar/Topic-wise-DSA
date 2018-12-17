t=int(input())
for k in range(t):
    a,b=list(map(int,input().strip().split(' ')))
    total1=0
    total2=0
    for j in range(a):
        mat=input()
        m=''
        for i in range(b-1):
            if(mat[i]==mat[i+1] and mat[i]=='R'):
                total1+=5
                
            elif(mat[i]==mat[i+1] and mat[i]=='G'):
                total1+=3
                
            if(mat[i]==mat[i+1] and mat[i+1]=='R'):
                total2+=3
                
            elif(mat[i]==mat[i+1] and mat[i+1]=='G'):
                total2+=5
        
        
    print(min(total1,total2))
                
