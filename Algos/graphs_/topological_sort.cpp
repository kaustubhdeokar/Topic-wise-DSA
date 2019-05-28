// A C++ Program to detect cycle in a graph 
#include<iostream> 
#include<bits/stdc++.h>
using namespace std; 

/*
6 6
1 2
1 3
2 5
2 6
3 4
4 5
*/
stack<int>s;

void print(vector<int>v[],bool visited[],int head,stack<int>s){
	
	if(visited[head]!=1){
	visited[head]=1;
	for(int j=0;j<v[head].size();j++)
		{
		print(v,visited,v[head][j],s);
		}
	cout<<head<<" ";
	}
	else
	return;

}

int main() 
{ 

	int x,y,nodes,edges,cost;
	cin>>nodes>>edges;
	vector<int>v[10];
	for(int i=0;i<edges;i++){
	cin>>x>>y;
	v[x].push_back(y);
	}
	bool visited[nodes]={0};
	print(v,visited,1,s);

	cout<<s.size();

	return 0;
} 

