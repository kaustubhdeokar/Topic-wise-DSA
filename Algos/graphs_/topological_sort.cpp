#include<iostream>
#include<bits/stdc++.h>
using namespace std;

void tpsort(int i,vector<int>v[],bool visited[],int nodes,stack<int>&answer){
    visited[i]=true;
    for(int j=0;j<v[i].size();j++){
        if(visited[v[i][j]]==false)
        {
            visited[v[i][j]]=true;
            tpsort(v[i][j],v,visited,nodes,answer);
        }
    }
           answer.push(i);
}

void topologicalsort(vector<int>v[],int nodes){
    bool visited[nodes];
    stack<int>answer;
    memset(visited,false,nodes*sizeof(bool));
    for(int i=0;i<nodes;i++){
        if(visited[i]==false)
        tpsort(i,v,visited,nodes,answer);
    }
    while(!answer.empty())
    {
        cout<<answer.top();
        answer.pop();
    }

}


int main(){

    int nodes=6;
    vector<int>v[10];
    v[5].push_back(2);
    v[5].push_back(0);
    v[4].push_back(0);
    v[4].push_back(1);
    v[2].push_back(3);
    v[3].push_back(1);
    topologicalsort(v,nodes);
}

