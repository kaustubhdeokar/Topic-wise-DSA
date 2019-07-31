#include <iostream>
#include<bits/stdc++.h>
#include<cmath>
using namespace std; 
#define ll long long

void show(priority_queue<int> q){

    while(!q.empty()){
        cout<<q.top()<<" ";
        q.pop();
    }
}


int main() { 

    vector<int>v={3, 1, 5, 2, 4};
    priority_queue<int>q(v.begin(),v.begin()+v.size());
    show(q);
    q.emplace(10);
    q.emplace(12);
    cout<<endl;
    show(q);
//    priority_queue<int>q;
//    q.push(3);
//    q.push(11);
//    q.push(5);
//    q.push(-3);
//    q.push(4);

return 0;
} 
