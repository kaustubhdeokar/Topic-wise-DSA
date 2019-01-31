#include<iostream>
#include<vector>
using namespace std;

void dfs(int head,int nodes,bool visited[],vector<int> v[]){
    int i;
    cout<<head<<" ";
    visited[head]=true;
    for(i=0;i<v[head].size();i++)
    {
        if(visited[v[head][i]]==false){
            visited[v[head][i]]=true;
            dfs(v[head][i],nodes,visited,v);
        }
    }
}
int main(){

    int a,b,i,nodes,edges;
    cin>>nodes>>edges;
    vector<int>v[edges*edges];
    for(i=0;i<edges;i++){
        cin>>a>>b;
        v[a].push_back(b);
    }
    bool visited[nodes+1]={false};
    
    
    dfs(1,nodes,visited,v);
    return 0;
}
