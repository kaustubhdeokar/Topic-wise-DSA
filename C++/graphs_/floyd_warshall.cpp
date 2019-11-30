#include<bits/stdc++.h> 
using namespace std; 
#define ll unsigned long long int
#define INF 100


int main(){
	int v=4;
	int graph[v][v] = { {0,   5,  INF, 10}, 
                        {INF, 0,   3, INF}, 
                        {INF, INF, 0,   1}, 
                        {INF, INF, INF, 0} 
                      }; 
		for(int k=0;k<v;k++){
			for(int i=0;i<v;i++){
				for(int j=0;j<v;j++){
					if(graph[i][j]>graph[i][k]+graph[k][j])
					graph[i][j]=graph[i][k]+graph[k][j];
				}
			}
		}

		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				if (graph[i][j] == INF) 
                printf("%7s", "INF"); 
				else
                printf("%7d", graph[i][j]); 
			}
			cout<<endl;
		}
				
	return 0;
}
