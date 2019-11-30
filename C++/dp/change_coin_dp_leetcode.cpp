#include<iostream>
#include<bits/stdc++.h>
#define maximum 1000
using namespace std;

void func(vector<int>arr,int total){

    vector<int>dp(total+1,0);
    dp[0]=1;
    for(const auto &n:arr){
        for(int i=n;i<=total;i++){
            dp[i]+=dp[i-n];
        }
    }
    for(const auto &n:dp){
        cout<<n<<" ";  
    }
}


int main(){

    int n,m;
    vector<int>arr={1,2,2,5};
    arr.erase(unique(arr.begin(),arr.end()),arr.end());
    int total=5;
    func(arr,total);
    return 0;
}