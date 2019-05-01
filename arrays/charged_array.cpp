#include<iostream>
#include<cmath>
using namespace std;
long long int mod=1000000007;
int main(){

//the main trick here was that if the number (N)size of the array would be >=64 then the total would be 0 as Ai ranges upto
// 10^18 then answer would be zero.

    long long int total=0,t,temp,power,n;
    cin>>t;
    while(t){
    cin>>n;
    power=pow(2,n-1);
    for(int i=0;i<n;i++){
        cin>>temp;
        if(temp>=power)
        total+=temp;
        total%=mod;
    }
    cout<<total<<endl;
    total=0;
    t--;
    }

    long long unsigned val=(1ll<<(63));
    cout<<val;
    return 0;
}