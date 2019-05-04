#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void bfs(int head,int nodes,bool visited[],vector<pair<int,long long int> >v[],int* min,int* max){
    int i;
	for(i=0;i<v[head].size();i++){
        if(visited[v[head][i].first]==false)
		{
   		visited[head]=true;
		visited[v[head][i].first]=true;
        bfs(v[head][i].first,nodes,visited,v,min,max);
        
        if(v[head][i].second<*min){
            *min=v[head][i].second;
        }
        if(v[head][i].second>*max){
            *max=v[head][i].second;
        }
        }
    }
}

int main(){
    int nodes,edges;
    cin>>nodes>>edges;
    int a,b,i,j,temp;
    long long int c;
    vector<pair<int,long long int> >v[100000];
    for(i=0;i<edges;i++){
        cin>>a>>b>>c;
        v[a].push_back(make_pair(b,c));
    }
    
    int max=INT_MIN;
    int min=INT_MAX;
    int globalmax=INT_MIN;
    if(edges==1){
        cout<<0;
    }
    else
    {    
    for(i=1;i<=nodes;i++){
        bool visited[nodes]={false};
        bfs(i,nodes,visited,v,&min,&max);
        if(max-min>globalmax)
        globalmax=max-min;
    }
    cout<<globalmax;
    }
    return 0;
}
