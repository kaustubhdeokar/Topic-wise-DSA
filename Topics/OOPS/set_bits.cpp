#include <bits/stdc++.h> 
#include<iostream>
using namespace std; 

class Shape{
    public:
        virtual void area()=0;
};

class Square:public Shape{
    int side;
    public:
        Square(int side){
            this->side=side;
        }
        void area(){
            cout<<"area:"<<side*side;
        }

};

class Rectangle:public Shape{
    int len,breadth;
    public:
        Rectangle(int len,int bre){
            this->len=len;
            this->breadth=bre;
        }
        void area(){
            cout<<"area:"<<len*breadth;
        }

};



int main(){
    
    Square s(10);
    s.area();
    Rectangle r(12,21);
    r.area();  
}
