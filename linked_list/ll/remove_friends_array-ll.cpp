#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int main(){
    int t;
    cin>>t;
    while(t){
        int temp,count=0,i,n,k;
        cin>>n>>k;
        vector<int> v;
        for(i=0;i<n;i++){
        cin>>temp;
        v.push_back(temp);
        }
        vector<int>::iterator j;
        for(auto j=v.begin();j!=v.end()-1;j++)
        {
        if(*j<*(j+1))
        v.erase(j); 
        count+=1;
        if(count==k)
        break;
        
        }
        for(auto j=v.begin();j!=v.end()-count+1;j++)
        {
        cout<<*j;
        }
        t-=1;
    }
    return 0;
}