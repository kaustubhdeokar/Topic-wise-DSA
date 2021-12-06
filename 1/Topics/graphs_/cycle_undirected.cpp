#include <bits/stdc++.h> 
using namespace std; 
int temp=1;
bool isCyclic(vector<int>graph[],int nodes,int head,bool visited[],int parent[]){
		
		visited[head]=true;
		int l=graph[head].size();
		for(int i=0;i<l;i++)
		{
			if(parent[graph[head][i]]==-1)
			parent[graph[head][i]]=head;
			else if(parent[graph[head][i]]!=head)
			{	
				temp=0;
				return true;
			}
			isCyclic(graph,nodes,graph[head][i],visited,parent);
		}
		if(temp!=0)
		return false;
		else
		return true;
}


int main() 
{ 
	int nodes,edges,t;
	cin>>t;
	while(t--){
		cin>>nodes>>edges;
		int u,v;
		vector<int>graph[1000];
		for(int i=0;i<edges;i++){
			cin>>u>>v;
			graph[u].push_back(v);
		}
		bool visited[nodes];
		memset(visited,false
,sizeof(bool)*nodes);
		int parent[nodes];
		memset(parent,-1,sizeof(int)*nodes);
		cout<<isCyclic(graph,nodes,0,visited,parent);
	}
	return 0; 
} 

