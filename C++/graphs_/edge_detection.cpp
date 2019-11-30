// A C++ Program to detect cycle in a graph 
#include<iostream> 
#include<bits/stdc++.h>
using namespace std; 

void print(vector<int>v[],int nodes,int edges){
	
	int count,a,b;
	int parentof[nodes]={0};
	bool visited[nodes]={0};
	for(int i=0;i<edges;i++){
		cout<<i+1<<":";
		for(int j=0;j<v[i+1].size();j++){
			cout<<v[i+1][j]<<" ";
			
			if(visited[v[i+1][j]]!=1)
			{
				visited[v[i+1][j]]=1;
				parentof[v[i+1][j]]=i+1;
			}
			else
			{
				cout<<"loop:->";
				a=parentof[v[i+1][j]];
				b=parentof[i+1];
				cout<<"a:"<<a<<"b:"<<b<<" ";
				while(a!=b){
					if(a!=1)
					a=parentof[a];
					if(b!=1)
					b=parentof[b];
					cout<<"a:"<<a<<"b:"<<b<<" ";
				}
				cout<<"out of while loop:"<<endl;				
			}	
		}
		cout<<endl;
	}
}
/*
6 7
1 2
1 3
2 5
2 6
3 4
4 5
3 6
*/
int main() 
{ 

	int x,y,nodes,edges;
	cin>>nodes>>edges;
	vector<int>v[10];
	int i;
	for(i=0;i<edges;i++){
		cin>>x>>y;
		v[x].push_back(y);
	}
	print(v,nodes,edges);
	return 0;
} 

