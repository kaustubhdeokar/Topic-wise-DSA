#include<iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int x;
    
    while(cin>>x){
        cout<<x<<"\n";
        if(x==42)
        break;
    }


    return 0;
}