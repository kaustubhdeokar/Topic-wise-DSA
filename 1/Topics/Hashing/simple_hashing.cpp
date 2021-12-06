#include<iostream>
#include<time.h>
#include<bits/stdc++.h>
#include<typeinfo>
using namespace std;


int hashfunc(char i){
    return i-'a';
}

int main(){

    string s="abcdabcd";
    int frequency[26]={0};
    for(int i=0;i<s.length();i++)
        frequency[hashfunc(s[i])]++;
    
    for(int j=0;j<26;j++){
        cout<<char(j+'a')<<" "<<frequency[j]<<endl;
    }

}
