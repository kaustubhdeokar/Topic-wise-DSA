#include<bits/stdc++.h>
using namespace std;

void bfs(vector<int>v[],int n){
    int p;
    queue<int>q;
    int level[n];
    int vis[n];
    q.push(v[0][0]);
    level[v[0][0]]=0;
    while(!q.empty()){
        p=q.front();
        q.pop();
        for(int i=0;i<v[p].size();i++){
            if(vis[v[p][i]]=false)
            {            
            q.push(v[p][i]);
            level[v[p][i]]=level[p]+1;
            vis[v[p][i]]=true;
            }
    }

}
    for(int j=0;j<n;j++)
    cout<<level[j]<<endl;
}

int main(){
    int n,i,j;
    cin>>n;
    vector<int>v[n*n];
    int x,y;
    for(i=0;i<n;i++)
    {
        cin>>x>>y;
        v[x].push_back(y);
    }

    for(i=0;i<n;i++){
        for(j=0;j<v[i].size();j++){
            cout<<v[i][j]<<" ";
        }
        cout<<endl;
    }
    bfs(v,n);
}