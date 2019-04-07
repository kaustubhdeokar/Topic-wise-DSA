#include<iostream>
#include<bits/stdc++.h>
using namespace std;



int main(){

    stack<int>s,s1;
    int temp,n,k;
    cin>>n>>k;
    for(int p=0;p<n;p++)
    {
        cin>>temp;
        s.push(temp);
    }


    int maxtillnow=INT_MIN;
    for(int i=0;i<n;i++){
        temp=s.top();
        s1.push(temp);
        s.pop();
    }

    for(int j=0;j<k;j++){
        temp=s1.top();
   //     cout<<temp;
        s1.pop();
        if(temp>maxtillnow)
        maxtillnow=temp;
    }

    cout<<maxtillnow;

    return 0;


}
