#include<iostream>
#include<bits/stdc++.h>
using namespace std;
long long int lli;
int main(){
    int nodes,edges;
    cin>>nodes>>edges;
    int i,j,temp,c,a,b;
    vector<pair<int,lli> >v[edges*edges];
    for(i=0;i<edges;i++){
        cin>>a>>b>>c;
        v[a].push_back(make_pair(b,c));
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