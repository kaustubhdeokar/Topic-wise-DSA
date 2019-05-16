#include<iostream>
#include<bits/stdc++.h>
using namespace std;


void permutestr(string s,string prefix){

    if(s.size()==0)
    cout<<prefix<<endl;

    for(int i=0;i<s.size();i++){
        string rem=s.substr(0,i)+s.substr(i+1);
        permutestr(rem,prefix+s.at(i));
    }

}

void permute(string s){
    permutestr(s,"");
}


int main(){
    
    string s;
    cin>>s;
    permute(s);
}
