#include<iostream>
#include<bits/stdc++.h>
#define ll  long long 
using namespace std;

int check(string s1,string s2){
    if(s1.length()==s2.length())
    {

        int temp=1;
        char s=s2[0];
        int start=s1.find(s);
        for(int i=0;i<s2.length();i++){
            if(s2[i]!=s1[(i+start)%s1.length()]){
            temp=0;
            break;
            }
        }
        if(temp==1)
        return 1;
        else
        return 0;
    }
    else
    return 1;
}

int main(){
    string s1,s2;
    cin>>s1>>s2;
    if(check(s1,s2))
    cout<<"yes";
    else
    cout<<"no";
    
    return 0;
}
