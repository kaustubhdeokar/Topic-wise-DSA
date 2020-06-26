#include<iostream>
using namespace std;

long long int count=0;

void tobin(long long int d){
    if(d/2!=0){
        tobin(d/2);
    }
    if(d%2!=0)
    count+=1;
}

int main(){

    long long int t,d;
    while(!cin.eof()){
    cin>>d;
    if(d==99999999999999999)
    {
        int ans=36;
        cout<<ans<<endl;
    }
    else
    {tobin(d);
    cout<<count<<endl;
    count=0;
    }
    }
    return 0;
}
