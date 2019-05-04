#include<iostream>
#include<bits/stdc++.h>

using namespace std;

class Stack{

    int size=0;
    int capacity;
    stack<int>s;
public:
    void init();
    void add();
    void pop();
    void print();
};

void Stack::init(){
    int tot;
    cout<<"enter the max capacity"<<endl;
    cin>>tot;
    capacity=tot;
}

void Stack::add(){
    


}

void Stack::pop(){
    if(capacity=0){
    cout<<"underflow"<<endl;
    }
    s.pop();
}

void Stack::print(){
    int temp;
    stack<int>tempstack;
    while(!s.empty()){
        temp=s.top();
        cout<<temp;
        s.pop();
        tempstack.push(temp);
    }
    s=tempstack;
}

int main(){

    Stack s1;

    cerr<<"error";

    // s1.init();
    // s1.add();
    // s1.pop();
    // s1.print();
    return 0;
    
}