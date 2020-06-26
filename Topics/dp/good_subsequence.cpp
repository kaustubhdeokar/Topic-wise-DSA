#include<iostream>
using namespace std;
int main(){

    string s="abcabc";
    int a=0,b=0,c=0;
    for(int i=0;i<s.length();i++){
        if(s[i]=='a')
        a+=(a+1);
        if(s[i]=='b')
        b+=(a+b);
        if(s[i]=='c')
        c+=(c+b);
    }
    cout<<c;
}