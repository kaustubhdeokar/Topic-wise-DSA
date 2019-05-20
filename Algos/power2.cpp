#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int powersof2(int n){
    cout<<n<<endl;
    if(n==0)
    return 0;
    else if(n==1)
    {
        cout<<"returned 1"<<endl;
        return 1;
    }
    else{
        int prev=powersof2(n/2);
        cout<<prev;
        int current=prev*2;
        return current;
    }
}


int main(){

    int n;
    cin>>n;
    int p=powersof2(n);
    return 0;
}

