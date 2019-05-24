//permutations pallindrome.
#include<iostream>
#include<bits/stdc++.h>
#include<algorithm>
#include<cmath>
using namespace std;

void print(vector<int>v[],int nodes){
    for(int i=1;i<=nodes;i++){
        cout<<i<<" ";
        for(int j=0;j<v[i].size();j++){
            cout<<v[i][j]<<" ";
        }
        cout<<endl;
    }

}

void bfs(vector<int>v[],int nodes,int head){
    
    queue<int>q;
    q.push(head);
    bool vis[nodes+1]={0};
    vis[head]=true;
    while(!q.empty()){
        int p=q.front();
        q.pop();
        cout<<p<<" ";
        for(int i=1;i<=nodes;i++){
            for(int j=0;j<v[i].size();j++){
                if(vis[v[i][j]]!=1)
                {
                    q.push(v[i][j]);
                    vis[v[i][j]]=1;
                }
            }
        }
    }

}

void dfs(vector<int>v[],int head,bool visited[]){

    visited[head]=1;
    cout<<head<<" ";
    for(int i=0;i<v[head].size();i++){
        if(visited[v[head][i]]!=1)
        {
            dfs(v,v[head][i],visited);
        }
    }

}

int main(){
    int n,nodes,edges;
    cin>>nodes>>edges;
    vector<int>v[10];
    int x,y;
    for(int i=1;i<=edges;i++){
        cin>>x>>y;
        v[x].push_back(y);
    }
//    print(v,nodes);
    bfs(v,nodes,1);
    cout<<endl;
    bool visited[nodes+1]={0};  
    dfs(v,1,visited);

    return 0;
}
