#include <iostream>
#include<bits/stdc++.h>
#include<cmath>
using namespace std; 
#define ll long long

void show(queue<int> q){

    while(!q.empty()){
        cout<<q.front();
        q.pop();
    }
}


int main() { 

auto its={1,2,3,4};
auto itz={4,3,2,1};

queue<int>q1(its);
queue<int>q2(itz);

q2.swap(q1);

    cout<<"q1"<<endl;
    show(q1);
    cout<<endl;
    cout<<"q2"<<endl;
    show(q2);
    cout<<endl;
q1=move(q2);
    cout<<"q1"<<endl;
    show(q1);
    cout<<endl<<"q2"<<endl;
    show(q2);


return 0;
} 
