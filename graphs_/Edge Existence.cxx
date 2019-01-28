#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main(){
    int nodes,edges;
    cin>>nodes>>edges;
    vector<int>v[edges*2];
    int a,b,i,j;
    for(i=0;i<edges;i++){
        cin>>a>>b;
        v[a].push_back(b);
    }
    int temp,queries;

    cin>>queries;
    for(j=0;j<queries;j++){
        temp=0;
        cin>>a>>b;
        for(i=0;i<v[a].size();i++){
            if(temp==1)
            break;
            if(v[a][i]==b){
                cout<<"YES"<<endl;
                temp=1;
            }
            
        }
        if(temp==0){
            cout<<"NO"<<endl;

        }
    }
    
    return 0;
}
