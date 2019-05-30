#include<iostream>
#include<bits/stdc++.h>
using namespace std;
/*
this program function operator overloading of []
this are the special operators [],(),->
we cannot use this with the frien function.
*/

class Marks{
   int subject[3];
   int a;
    public:

   Marks(int a,int b,int c){
      subject[0]=a;
      subject[1]=b;
      subject[2]=c;
   }

   int operator[](int k){
      cout<<subject[k];
   }

   void display(){
      cout<<a;
   }

};


int main () {

   Marks a(12,13,14);
   a[1];

}

