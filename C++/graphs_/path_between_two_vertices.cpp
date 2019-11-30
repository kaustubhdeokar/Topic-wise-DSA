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
        void pathbetween(int a,int b);
        void dfs(int head,int tosearch,stack<int>st,bool visited[]);
};

void Graph::addEdge(int a,int b){
    arr[a].push_back(b);
}

void dfs(int head,int tosearch,stack<int>&st,bool visited[]){

    st.push(head);
    visited[head]=true;
    list<int>::iterator i;
    if(head==tosearch)
    return;
    for(i=arr[head].begin();i!=arr[head].end();i++){
        
    }

}

void Graph::pathbetween(int a,int b){
    stack<int>st;
    bool visited[vertices];
    for(int i=0;i<vertices;i++)
    visited[i]=false;
  
    dfs(a,b,st,visited);

}

int main(){


    Graph g(4); 
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(0, 3); 
    g.addEdge(2, 0); 
    g.addEdge(2, 1); 
    g.addEdge(1, 3); 
    g.pathbetween(0,3);

    return 0;
}