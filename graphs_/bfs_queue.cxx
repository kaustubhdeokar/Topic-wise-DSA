#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main(){
    int nodes,edges;
    cin>>nodes;
    edges=nodes-1;
    int i,j,temp,a,b;
    vector<int>v[edges*edges];
    for(i=0;i<edges;i++){
        cin>>a>>b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    int head=v[1][0];
    bool marked[nodes]={false};
    int level[nodes]={1};
    queue<int>q;
    q.push(head);
    while(!q.empty()){
        temp=q.front();
      //  cout<<"temp is:"<<temp<<endl;
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
    int l,c=0;
    cin>>l;
    for(j=1;j<=nodes;j++){
    cout<<j<<" "<<level[j]<<endl;
    }
    cout<<c;
    return 0;
}