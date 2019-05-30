#include<iostream>
#include<bits/stdc++.h>
using namespace std;


class Matrix{
   

   int a[10],n;
   public:
   Matrix(){
       a[10]={0};
   }
   Matrix(int n){
       this->n=n;
       cout<<"enter the numbers"<<endl;
       for(int i=0;i<n;i++)
       cin>>a[i];
   }
   Matrix operator+(Matrix c){
       Matrix temp;
        for(int i=0;i<this->n;i++){
            temp.a[i]=a[i]+c.a[i];
        }
        return temp;
   }

    void display(){
        for(int i=0;i<n;i++)
        cout<<this->a[i];
    }
};

int main(){

    Matrix m1(2);
    Matrix m2(2);
    Matrix m3=m1+m2;
    m3.display();
    return 0;
}
