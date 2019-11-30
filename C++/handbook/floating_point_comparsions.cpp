#include<iostream>
using namespace std;
#define e 1e-9
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    float x=0.3*3+0.1;
    float y=1;
    cout<<x<<endl;
    if(y-x){
        cout<<"yes";
    }
    else{
        cout<<"no";
    }

    return 0;
}
