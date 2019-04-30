#include<iostream>
using namespace std;
int main(){
    int d;
    cin>>d;
    if((d&(d-1))==0)
    {
        cout<<"yes";
    }
    else{
        cout<<"no";
    }
    return 0;
}