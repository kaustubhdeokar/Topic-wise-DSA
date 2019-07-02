#include<iostream>
#include<bits/stdc++.h>
using namespace std;
#define sizearr 1000
string arrays[sizearr];
int arrayint=0;

void permutestring(string  s,string prefix){
    
    if(s==""){
      arrays[arrayint++]=prefix;
    }
    else{
		int len=s.length();
        for(int i=0;i<len;i++){
            string rem=s.substr(0,i)+s.substr(i+1);
            permutestring(rem,prefix+s.at(i));
        }
    }
}

void permute(string s){
    permutestring(s,"");
}

int main(){

    string s;
    cin>>s;
    permute(s);
    sort(arrays,arrays+arrayint);
    for(int i=0;i<arrayint;i++)
    cout<<arrays[i]<<" ";
}
