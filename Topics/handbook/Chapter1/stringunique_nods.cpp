//string has all unique characters. without any data structure.
#include<iostream>
#include<bits/stdc++.h>
using namespace std;



int main(){


    string s;
    cin>>s;
    sort(s.begin(),s.end());
    cout<<s<<endl;
    int temp=0;
    for(int i=0;i<s.length()-1;i++){
        if(s[i]==s[i+1])
        {
            temp=1;
            break;
        }
    }

    if(temp==1)
    cout<<"no";
    else
    cout<<"yes";
     return 0;
}

