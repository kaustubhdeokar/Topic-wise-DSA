#include<bits/stdc++.h>
#include<iostream>
using namespace std;
#define V 4
#define INF 9999

bool detectnegative(int graph[][V]){
    int temp=0;
  for (int i = 0; i < V; i++){
    if (graph[i][i] < 0){
      temp=1;
      break;
    }
    else
      continue;
  }
  if(temp==1)
  return true;
  else
  return false;  
}

bool floydwarshall(int graph[][V]){

  int i,j,k;
  for(int k=0;k<V;k++){
    for(int i=0;i<V;i++){
      for(int j=0;j<V;j++){
        if(graph[i][j]>(graph[i][k]+graph[k][j]))
        graph[i][j]=graph[i][k]+graph[k][j];
      }
    }
  }
  return detectnegative(graph);

}

int main()
{
int graph[V][V] = { {0   , 1   , INF , INF}, 
                        {INF , 0   , -1  , INF}, 
                        {INF , INF , 0   ,  -1}, 
                        {-1  , INF , INF ,   0}}; 

  if(floydwarshall(graph))
  cout<<"there exists a negative cycle";
  else
  cout<<"does not exist";
  return 0;
}


