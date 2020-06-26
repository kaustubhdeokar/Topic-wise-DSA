#include <bits/stdc++.h> 
#include<iostream>
using namespace std; 

class Parent {
    public:
    virtual void sleep() {
        cout<<"sleeping";
    }
};

class Child: public Parent {
    public:
    void sleep(){
        cout<<"schooling";
    }
};

int main( ) 
{ 
  Parent *p;
  Child c;
    p=&c;
    p->sleep();
  return 0; 
}