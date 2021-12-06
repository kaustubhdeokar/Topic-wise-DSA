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

	/*
	 * couting the frequency of the words
	 *     unordered_map<string,int>m;
    string s;
    getline(cin,s);
    stringstream ss(s);
    string word;
    while(ss>>word)
    m[word]++;

    for(auto x:m){
        cout<<x.first<<x.second<<endl;
    }

    return 0;

}
	 * */


    return 0;

}
