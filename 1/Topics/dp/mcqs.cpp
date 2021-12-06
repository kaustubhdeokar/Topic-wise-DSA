#include<iostream>
#include<stdio.h>
using namespace std;

struct User{
    string name;
    int age;
};

void print(User a){
    a.name="ka";
    cout<<a.name<<a.age<<endl;

}

void fun(int n,int m){
    for(;n>=m;n--)
    cout<<n<<" ";
}

int main(){
    
    void (*ptr)(int,int)=fun;
    (*ptr)(3,1);
    ptr(3,1);
    return 0;
}