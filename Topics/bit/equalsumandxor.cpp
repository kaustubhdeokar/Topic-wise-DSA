//equal sum and xor.
//12+x=12^x--> how many  x(s)
#include<bits/stdc++.h>
#include <iostream>
using namespace std;

void equalsumandxor(int n){

    int unset=ceil(log2(n))-__builtin_popcount(n);
    if(unset!=0)
    cout<<pow(2,unset);
    else
    cout<<1;
}

int main() {

    int count=0,n;
    cin>>n;
    for(int i=0;i<n;i++){
        if((n^i)==(n+i))
        count+=1;
    }
    cout<<count;
    equalsumandxor(n);
}

