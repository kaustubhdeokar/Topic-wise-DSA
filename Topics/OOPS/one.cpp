#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Matrix{
    public:
      int x;
      Matrix(){
         x=0;
      }
      Matrix(int x){
         this->x=x;
      }

      void operator++(){
         x=x+1;
      }
      friend void operator--(Matrix& obj);
      void display(){
         cout<<x;
      }
      Matrix operator++(int){
         Matrix duplicate(*this);
         duplicate.x=x+3;
         return duplicate;
      }  
};

void operator--(Matrix& obj){
   obj.x=obj.x-1;
}

int main () {

   Matrix a(10);
   ++a;
   --a;
   Matrix b=a++;

   b.display();
}

