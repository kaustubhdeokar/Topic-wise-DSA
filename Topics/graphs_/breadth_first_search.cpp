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
        void bfs(int head);
};

void Graph::addEdge(int a,int b){
    arr[a].push_back(b);
}

void Graph::bfs(int head){

    bool visited[vertices];
    for(int i=0;i<vertices;i++)
    visited[i]=false;
    list<int>::iterator i;
    queue<int>q;
    q.push(head);
    visited[head]=true;
    while(!q.empty()){
        head=q.front();
        cout<<head<<" ";
        q.pop();
        for(i=arr[head].begin();i!=arr[head].end();++i){
            if(!visited[*i]){
                visited[*i]=true;
                q.push(*i);
            }   
        }
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
  
    g.bfs(2);

    return 0;
}