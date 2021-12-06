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
  Parent *parent;
  Child child;
  parent=&child; 
  parent->sleep();
  return 0; 
}