#include<iostream>
#include<bits/stdc++.h>
using namespace std;


bool SchoolsPrime(int n){

    if(n<=1)return false;
    if(n<=3)return true;
    if(n%2==0 || n%3==0)
    return false;
    for(int i=5;i*i<=n;i+=6){
        if((n%i==0)||(n%(i+2)==0))
        return false;
        }
    return true;
}

int main(){

    int n;
    cout<<"enter number"<<endl;
    cin>>n;
    bool t=SchoolsPrime(n);
    cout<<t;
    return 0;
}
