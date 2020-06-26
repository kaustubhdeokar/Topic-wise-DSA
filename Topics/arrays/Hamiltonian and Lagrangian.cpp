#include<iostream>
#include<cmath>
#include<bits/stdc++.h>
using namespace std;

int main(){
    int n,i;
    stack<int>s;
    cin>>n;
    int arr[n];
    for(i=0;i<n;i++){
        cin>>arr[i];
    }
    int max=-1;
    for(i=n-1;i>=0;i--){
        if(arr[i]>max){
            s.push(arr[i]);
            max=arr[i];
        }
    }
    while(!s.empty()){
    cout<<s.top()<<" ";
    s.pop();
    }

    return 0;
}