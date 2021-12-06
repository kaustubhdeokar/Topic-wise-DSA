//permutations pallindrome.
#include<iostream>
#include<bits/stdc++.h>
#include<algorithm>
using namespace std;


bool pallindrome(string s){
    int l=s.length();
    int temp=0;
    for(int i=0;i<s.length()/2;i++){
        if(s.at(i)!=s.at(l-i-1))
        {
            temp=1;
            break;
        }
    }
    if(temp!=1)
    return true;
    else
    return false;
}

void permuteforreal(string s,string prefix){

    if(s.length()==0){
    if(pallindrome(prefix))
    cout<<prefix<<":is a pallindrome"<<endl;
    else
    cout<<prefix<<endl;
    }
    for(int i=0;i<s.length();i++){
        string rem=s.substr(0,i)+s.substr(i+1);
        permuteforreal(rem,prefix+s.at(i));
    }

}

void permute(string s){
    permuteforreal(s,"");
}

int main(){
    
    string s;
    cin>>s;
    permute(s);
    return 0;
}
