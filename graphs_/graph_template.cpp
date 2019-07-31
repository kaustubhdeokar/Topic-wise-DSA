#include<iostream>
#include<bits/stdc++.h>
#define maximum 1000
using namespace std;

class Graph{
    list<int>*arr;
    int vertices;
    public:
        Graph(int ver){
            vertices=ver;
            arr=new list<int>[vertices];
        }
        void addEdge(int a,int b);
        void print(int h);
        void printUtil(int h,bool visited[],unordered_map<int,int>umap);
};

void Graph::addEdge(int a,int b){
    arr[a].push_back(b);
}

void Graph::printUtil(int head,bool visited[],unordered_map<int,int>umap){

    visited[head]=true;
    umap[head]=1;
    list<int>::iterator it;
    for(it=arr[head].begin();it!=arr[head].end();it++){
        if(!visited[*it])
        printUtil(*it,visited,umap);
         else if(visited[*it] && umap[*it]){
         cout<<"has";
         return;
         }
    }
    umap[head]=0;
    cout<<head<<" ";
}

void Graph::print(int head){    
    bool visited[vertices];
    unordered_map<int,int>umap;
    memset(visited,false,sizeof(bool)*vertices);
    printUtil(head,visited,umap);
}

int main(){

    Graph g(5);
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(2,3);
    g.addEdge(3,1);
    g.print(0);
    return 0;
}