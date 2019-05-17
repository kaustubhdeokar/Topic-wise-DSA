#include<iostream>
#include<time.h>
#include<bits/stdc++.h>
#include<typeinfo>
using namespace std;


int main(){

    int temp,n,k;
    cin>>n>>k;
    unordered_map<int,int>m;
    for(int i=0;i<n;i++){
        cin>>temp;
        m[temp]++;
    }
    temp=0;
    for(auto x:m){
        if(m.find(k-x.first)!=m.end())
        {
            cout<<"YES"<<endl;
            temp=1;
            break;
        } 
    }

    if(temp!=1)
    cout<<"NO";
    return 0;
}


