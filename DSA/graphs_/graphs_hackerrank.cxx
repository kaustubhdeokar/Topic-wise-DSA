#include<iostream>
#include<vector>
using namespace std;
int main()
{
    vector <int> adj[10];
    int x, y,j, nodes, edges;
    cin >> nodes;       
    cin >> edges;       
    for(int i = 0;i < edges;++i)
    {
    cin >> x >> y;
    adj[x].push_back(y);
    }

    cout<<"output:"<<endl;
    for(int i = 1;i <= nodes;i++)
    {   
        cout<<i<<"-->";
        for(j=0;j<adj[i].size();j++){
            cout<<adj[i][j]<<" ";
        }
        cout<<endl;
    }
    

    return 0;
}