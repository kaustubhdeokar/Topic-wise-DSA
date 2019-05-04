#include<iostream>
#include<bits/stdc++.h>
using namespace std;
long long int lli;
int main(){
    int nodes,edges;
    cin>>nodes>>edges;
    int i,j,temp,a,b;
    vector<int>v[edges*edges];
    for(i=0;i<edges;i++){
        cin>>a>>b;
        v[a].push_back(b);
    }
    v[0].push_back(1);
    int head=0;
    bool marked[nodes]={false};
    int level[nodes]={1};
    queue<int>q;
    q.push(head);
    while(!q.empty()){
        temp=q.front();
        cout<<temp<<" ";
        marked[temp]=true;
        for(j=0;j<v[temp].size();j++){
            if(marked[v[temp][j]]==false){
                q.push(v[temp][j]);
                marked[v[temp][j]]=true;
                level[v[temp][j]]=level[temp]+1;
        //        cout<<"visiting"<<v[temp][j]<<endl;          
            }
            else{
//              cout<<"visited"<<v[temp][j];  
            }
        }
        q.pop();
    }


    return 0;
}