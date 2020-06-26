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
	void transitiveclosure();
	void DFSUtil(int s,int v);
};

void Graph::addEdge(int v,int w){
	arr[v].push_back(w);
}

void Graph::DFSUtil(int s,int v){

	matrix[s][v]=true;
	list<int>::iterator i;
	for(i=arr[v].begin();i!=arr[v].end();i++){
		if(matrix[s][*i]==false){
			DFSUtil(s,*i);
		}
	}
}

void Graph::transitiveclosure(){

	for(int i=0;i<vertices;i++)
		memset(matrix[i],false,sizeof(bool)*vertices);

	for(int i=0;i<vertices;i++)
		DFSUtil(i,i);

	for (int i=0; i<vertices; i++) { 
        for (int j=0; j<vertices; j++) 
            cout << matrix[i][j] << " "; 
        cout << endl; 
    } 
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
	g.transitiveclosure();
	return 0;
}