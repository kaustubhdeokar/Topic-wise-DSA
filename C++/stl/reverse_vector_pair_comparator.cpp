#include<iostream>
#include<bits/stdc++.h>
#define maximum 1000
using namespace std;

bool sortbysec(const pair<int,char>&v1,const pair<int,char>&v2){
    return v1.first>v2.first;
}

int main(){

    string s="hhhwg";
    
    map<char,int>m;

    for(int i=0;i<s.length();i++){
        char c=s[i];
        m[c]+=1;
    }
    for(auto x:m)
        cout<<x.first<<" "<<x.second<<endl;

    vector<pair<int,char>>v;
    for(auto x:m){
        v.push_back(make_pair(x.second,x.first));
    }

    sort(v.begin(),v.end(),sortbysec);
    for(auto x:v)
        cout<<x.first<<" "<<x.second<<endl;

    return 0;
}