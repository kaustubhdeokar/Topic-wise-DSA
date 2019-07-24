#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Graph{
	int vertices;
	list<int>*arr;
  public:
	Graph(int s){
		vertices=s;
		arr=new list<int>[vertices];
	}
	void addEdge(int a,int b);
	void printbfs(int head);
	void printdfs(int head);
	void DFS(int head,bool visited[],int dis[]);
};

void Graph::addEdge(int a,int b){
	arr[a].push_back(b);
	arr[b].push_back(a);
}

void Graph::printbfs(int head){
	
	bool visited[vertices];
	for(int i=0;i<vertices;i++)
	visited[i]=false;
		
	queue<int>q;
	q.push(head);
	visited[head]=true;
	list<int>::iterator i;
	
	while(!q.empty()){
		int s=q.front();
		cout<<s<<" ";
		q.pop();
		
		for(i=arr[s].begin();i!=arr[s].end();++i){

			if(!visited[*i]){
				visited[*i]=true;
				q.push(*i);
			}
		}
	}
}

void Graph:: DFS(int head,bool visited[],int dis[]){
	
	visited[head]=true;
	cout<<head<<" ";
	list<int>::iterator i;
	for(i=arr[head].begin();i!=arr[head].end();++i){
		if(!visited[*i])
		dis[*i]=dis[head]+1;
		DFS(*i,visited,dis);
	}
	cout<<"here"<<endl;
}

void Graph::printdfs(int head){
	
	bool visited[vertices];
	for(int i=0;i<vertices;i++)
	visited[i]=false;
	
	DFS(head,visited,dis);	
	cout<<endl;
	
}

int main(){
	//	Graph g(4); 
    //  g.addEdge(0, 1); 
    //  g.addEdge(0, 2); 
    //  g.addEdge(1, 2); 
    //  g.addEdge(2, 0); 
    //  g.addEdge(2, 3); 
    //  g.addEdge(3, 3);	
    //  g.printdfs(2);
    
	return 0;
}
