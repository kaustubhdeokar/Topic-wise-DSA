#include<iostream>
#include<bits/stdc++.h>
using namespace std;


class Student{
    public: 
        string name;
        int age;
};



int main(){

    map<int,Student>m;
    int id;
    cout<<"enter id";
    cout<<"name and age"<<endl;
    Student s;
    
    for(int i=0;i<3;i++){
    cin>>id;    
    cin>>s.name>>s.age;
    m[id]=s;
    }

    for(auto x:m){
        cout<<"id"<<x.first;
        cout<<"age"<<x.second.age;
        cout<<"name"<<x.second.name;
        cout<<endl;
    }


    return 0;

}
