#include <bits/stdc++.h> 
using namespace std; 
int temp=1;

void toposort(bool visited[],vector<int>graph[],int n,stack<int>& s){
		
	visited[n]=true;
	int l=graph[n].size();
	for(int i=0;i<l;i++)
	{
		if(visited[graph[n][i]]==false)
		toposort(visited,graph,graph[n][i],s);
	}
	s.push(n);	
}

void topologicalsort(vector<int>graph[],int nodes)
{
	stack<int>s;
	bool visited[nodes];
	memset(visited,false,sizeof(bool)*nodes);
	for(int i=0;i<nodes;i++)
	{
		if(visited[i]==false)
		toposort(visited,graph,i,s);
	}
	while(!s.empty())
	{
		cout<<s.top();
		s.pop();
	}
}

/*
1
6 6 
5 0 4 0 5 2 4 1 2 3 3 1 
*/

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
		topologicalsort(graph,nodes);
	}
	return 0; 
} 
