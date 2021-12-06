//string has all unique characters. without any data structure.
#include<iostream>
#include<bits/stdc++.h>
#include<algorithm>
using namespace std;

string stripped(string s){
    int last=0;
    for(int i=0;i<s.length();i++){
        if((s.at(i)>96 && s.at(i)<123)||(s.at(i)>64 && s.at(i)<91))
        last=i;
    }
    s=s.substr(0,last+1);
    return s;
}


int main(){


    string s;
    getline(cin,s);
    s=stripped(s);
    int f=0;
    while(f<s.length()){
    f=s.find(" ");
    if(f!=string::npos)
    s=s.substr(0,f)+"@"+s.substr(f+1);
    }
    cout<<s;
    return 0;
}
