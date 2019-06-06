#include<iostream>
#include<bits/stdc++.h>
using namespace std;
#define sizearr 100
string arrays[sizearr];
int arrayint=0;

void permutestring(string  s,string prefix){
    
    if(s==""){
//      array[arrayint++]=prefix;
    }
    else{
        for(int i=0;i<s.length();i++){
            string rem=s.substr(0,i)+s.substr(i+1);
            if(rem!="" && rem.length()==2)
            arrays[arrayint++]=rem;
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
    cout<<arrays[i];
}
