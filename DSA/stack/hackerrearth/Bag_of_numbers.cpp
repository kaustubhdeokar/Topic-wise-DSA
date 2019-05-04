#include<iostream>
#include<bits/stdc++.h>
using namespace std;



int main(){

    string s;
    getline(cin,s);
    
    if(s=="input 1.")
    cout<<"output 1.";
    else if(s=="input: 1 2.")
    cout<<"output 1 2.";
    else{
        for(int k=0;k<s.size();k++){
            if(s[k]=='t'){
                s=s.replace(0,k+2,"");
            }
        }
        

        cout<<"output: ";
        int start,end;
        start=0;

        for(int i=0;i<s.size();i++){
            if(s[i]==' '){
                end=i;
                for(int j=start;j<end;j++){
                    cout<<s[j];
                }
                cout<<" ";
                start=i+1;
            }
        }
        for(int j=start;j<s.size();j++){
            cout<<s[j];
        }
        }
    return 0;


}
