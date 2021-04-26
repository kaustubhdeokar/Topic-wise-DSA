#include <iostream>
using namespace std;

void check(long long int n,long long int result,long long int x){
    x=x%4;
    n=n/4;

    if(x==3){
    
        if(n==0)
        {
            result=result+51;
            cout<<result<<endl;
        }
        else
        {
            result=result+n*44+4+51;
            cout<<result<<endl;;
        }
    }
    
    else if(x==2 ){
         if(n==0){
        result=result+36;
        cout<<result<<endl;;
    }else{
        result=result+44*n+8+36;
           cout<<result<<endl;;

    }
        

    }

else if(x==1){
    if(n==0){
           result=result+20;
           cout<<result<<endl;;
       
    }else{
        result=result+44*n+12+20;
        cout<<result<<endl;
    }
     }

     else{
         result=result+n*44+16;
         cout<<result<<endl;;
     }
}

    


int main() {
    long long int t;

cin>>t;
long long int n;
for( long long int i=0;i<t;i++){
    cin>>n;
    check(n,0,n);
}
return 0;

}   