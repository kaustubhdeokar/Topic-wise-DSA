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
        void dfs(int head);
        bool dfsutil(int head,bool visited[],int recstack[]);
};

void Graph::addEdge(int a,int b){
    arr[a].push_back(b);
}

bool Graph::dfsutil(int head,bool visited[],int recstack[]){

    if(visited[head]==false){
        recstack[head]=true;
        visited[head]=true;
        cout<<head<<" ";
        list<int>::iterator i;
        for(i=arr[head].begin();i!=arr[head].end();i++){
        if(!visited[*i] && dfsutil(*i,visited,recstack))
        return true;
        else if(recstack[*i])
        return true;
        }
    }
    recstack[head]=false;
    return false;
}

void Graph::dfs(int head){

    bool visited[vertices];
    for(int i=0;i<vertices;i++)
    visited[i]=false;
    int recstack[vertices];
    memset(recstack,0,vertices*sizeof(int));
    for(int i=0;i<vertices;i++){
    if(dfsutil(i,visited,recstack))
    cout<<"is cycle"<<endl;
    }

}

int main(){

    Graph g(4); 
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3);
    g.dfs(0);

    return 0;
}