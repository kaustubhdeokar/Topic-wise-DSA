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
      void operator+=(Matrix k){
         x=x+k.x;
      }
      void operator+=(int k){
         x=x+k;
      }
      friend void operator-=(Matrix &obj,int k);

      void display(){
         cout<<x;
      }
};

void operator-=(Matrix &obj,int k){
   obj.x=obj.x-k;
}

int main () {

   Matrix a(10);
   Matrix b(20);
   a+=b;
   a-=2;
   a+=4;
   a.display();
}

