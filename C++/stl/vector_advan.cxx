#include<bits/stdc++.h>
#include <iostream>
using namespace std;
int main(int argc, char **argv)
{
	vector<int>v[10];
	int nodes,j,x,y,edges,i;
	cout<<"enter nodes and edges"<<endl;
	cin>>nodes>>edges;
	for(i=0;i<edges;i++)
	{
		cin>>x>>y;
		v[x].push_back(y);
	}
	for(i=0;i<nodes;i++)
	{
		for(j=0;j<v[i+1].size();j++)
		cout<<v[i+1][j];
		cout<<endl;
	}
	return 0;
}

