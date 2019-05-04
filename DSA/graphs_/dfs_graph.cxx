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
        v[b].push_back(a);
    }
    bool visited[nodes+1]={false};
    
    int head,j;
    cin>>head;
    
    dfs(head,nodes,visited,v);
    int c=0;
    for(j=1;j<=nodes;j++)
    if(visited[j]==0)
    c+=1;
    cout<<c;
    return 0;
}
