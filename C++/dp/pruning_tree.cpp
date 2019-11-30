#include<bits/stdc++.h> 
#include<iostream>
using namespace std; 

class Graph{

	list<int>*arr;
	int vertices;
	bool matrix[100][100];
	public:

	Graph(int v){
		vertices=v;
		bool matrix[vertices][vertices];
		arr=new list<int>[vertices];
	}
	void addEdge(int v,int w);
	void countPath(int s,int v);
	void countPathUtil(int s,int v,bool visited[],int &pathcount);
};

void Graph::addEdge(int v,int w){
	arr[v].push_back(w);
	arr[w].push_back(v);
}

void Graph::countPathUtil(int s,int v,bool visited[],int &pathcount){

	visited[s]=true;
	if(s==v)
	pathcount+=1;
	list<int>::iterator i;
	for(i=arr[s].begin();i!=arr[s].end();i++){
		if(!visited[*i])
		countPathUtil(*i,v,visited,pathcount);
	}
	visited[s]=false;
}

void Graph::countPath(int s,int v){
	bool visited[vertices];
	memset(visited,false,sizeof(bool)*vertices);
	int pathcount=0;
	countPathUtil(s,v,visited,pathcount);
	cout<<"the path count is:"<<pathcount<<endl;
}

int main()
{
	int k = 3; 
	bool isprime[10000];
	memset(isprime,true,sizeof(bool)*10000);
	for(int i=2;i*i<10000;i++){
		for(int j=i*i;j<10000;j+=i){
			if(isprime[j]==true)
			isprime[j]=false;
		}
	}


	// Graph g(4); 
    // g.addEdge(0, 1); 
    // g.addEdge(0, 2); 
    // g.addEdge(0, 3); 
    // g.addEdge(2, 0); 
    // g.addEdge(2, 1); 
    // g.addEdge(1, 3); 
	// g.countPath(2,3);
	return 0;
}