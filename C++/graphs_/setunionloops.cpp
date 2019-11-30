#include <bits/stdc++.h>
using namespace std;

void print(vector<int>v[]){
  
}
/*
3 3
0 1
1 2
2 0
 */
int setofparent(int arr[],int k){
		
	while(arr[k]!=-1)
	{
		k=arr[k];
	}
	return k;	
}

int main(){
  
  vector<int>v[100];
  int x,y,edges,nodes;
  cin>>edges>>nodes;
  for(int i=0;i<edges;i++){
    cin>>x>>y;
    v[x].push_back(y);
  }
  int parent[nodes];
  memset(parent,-1,sizeof(parent));

  int a,b;
  for(int i=0;i<nodes;i++){
	  for(int j=0;j<v[i].size();j++){
		a=setofparent(parent,i);
		b=setofparent(parent,v[i][j]);
		if(a!=b){
			parent[i]=v[i][j];
			continue;
		}
		else
		cout<<"loop";
	 }
  }
  return 0;
}

