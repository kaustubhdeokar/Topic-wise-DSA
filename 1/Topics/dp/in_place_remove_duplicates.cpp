#include<iostream>
using namespace std;

int main(){

    string s;
    cin>>s;

    string alpha="";
    for(int i=0;i<62;i++)
    alpha+='0';

    int b;
    string answer="";
    for(int i=0;i<s.length();i++){
        if(s[i]>47 && s[i]<58)
        b=52+s[i]-'0';
        if(isupper(s[i])==256)
        b=26+s[i]-'A';
        else
        b=s[i]-'a';
        if(alpha[b]=='0'){
            answer+=s[i];
            alpha[b]=1;
        }       
    }
    cout<<answer;
    return 0;
}