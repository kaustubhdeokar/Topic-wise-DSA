#include<bits/stdc++.h>
#include<vector>
using namespace std;

void addedges(vector<int> adj[],int x,int y){
    adj[x].push_back(y);
    adj[y].push_back(x);
}

void findk(vector<int> adj[],int arr[],int k,int nodes){
    int i,j;
    for(i=0;i<nodes;i++){
        for(j=0;j<adj[i].size();j++){
            cout<<adj[i][j];
        }
    }

}

int main(){
    int i,j,n,m,k;
    cin>>n>>m>>k;
    int arr[n];
    //entering the array
   
    for(i=0;i<n;i++)
    cin>>arr[i];
    
    //entering the edges
    
    vector<int>adj[n];
    int x,y;
    for(i=0;i<m;i++){
        cin>>x>>y;
        addedges(adj,x,y);
    }

    for(i=0;i<n;i++){
        for(j=0;j<adj[i].size();j++){
            cout<<adj[i][j];
        }
    }
    
   // findk(adj,arr,k,n);

    return 0;
}