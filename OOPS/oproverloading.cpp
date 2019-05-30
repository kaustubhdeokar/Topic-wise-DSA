#include<iostream>
#include<bits/stdc++.h>
using namespace std;
/*
this are the special operators [],(),->
we cannot use this with the frien function.
*/

class Marks{
   int subject[3];
   int a;
    public:

   Marks(int a){
      this->a=a;
      cout<<"this is the constructor"<<endl;
   }

   Marks operator()(int k){
      a=k;
      return *this;
   }

   void display(){
      cout<<a;
   }

};


int main () {

   Marks bro(2);
   bro(22);
   bro.display();
}

