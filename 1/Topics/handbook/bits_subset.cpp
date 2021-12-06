#include<iostream>
using namespace std;

int main(){
    char a[]={'a','b','c'};
    int n=3;
    int i,j;
    for(i=0;i<(1<<n);i++){

        for(j=0;j<n;j++){
            if((i&(1<<j))>0){
                cout<<a[j];
            }
        }
        cout<<endl;      

    }


}