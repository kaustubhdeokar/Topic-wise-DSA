#include<iostream>
#include<vector>
#include<bits/stdc++.h>

using namespace std;

int main(){
    int i,j,a,b,c,temp,nodes,edges;
    cin>>nodes>>edges;
    const int max=1e4+5;
    pair<long long,pair<int,int> >p[max];
    int weights;
    for(i=0;i<edges;i++){
        cin>>a>>b>>weights;
        p[i]=make_pair(weights,make_pair(a,b));
    }
    sort(p,p+edges);
    int mcost=0;
    bool visited[nodes]={false};
    for(i=0;i<edges;i++){
    if(visited[p[i].second.first]==false || visited[p[i].second.second]==false){
        mcost+=p[i].first;
        visited[p[i].second.first]=true;
        visited[p[i].second.second]=true;
        cout<<"visited edges"<<p[i].second.first<<" "<<p[i].second.second<<endl;
    }

    }
        cout<<mcost;
    return 0;
}