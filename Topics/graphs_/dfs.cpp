#include<bits/stdc++.h> 
#include<iostream>
using namespace std; 

class Graph{
	list<int>*arr;
	int vertices;
	public:
	Graph(int v){vertices=v;arr=new list<int>[vertices];}
	void addEdge(int v,int w);
	void BFS(int s);
	void DFS(int s);
	void DFSUtil(int source,bool visited[]);
};

void Graph::addEdge(int v,int w){
	arr[v].push_back(w);
}

void Graph::DFSUtil(int source,bool visited[]){

	visited[source]=true;
	cout<<source<<" ";
	list<int>::iterator i;
	for(i=arr[source].begin();i!=arr[source].end();i++){
		if(!visited[*i])
		DFSUtil(*i,visited);
	}
}

void Graph::DFS(int source){
	list<int>::iterator i;
	bool visited[vertices];
	for(int i=0;i<vertices;i++)
		visited[i]=false;

	DFSUtil(source,visited);	
	
}

int main()
{
	Graph g(4); 
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3); 
	g.DFS(2); 
	return 0;
}