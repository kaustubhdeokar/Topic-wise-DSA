#include<iostream>
#include<cmath>
using namespace std;
#define e 1e-9
int main(){

    int n;
    cin>>n;
    double a=pow((1+sqrt(5)),n);
    double b=pow((1-sqrt(5)),n);
    double c=pow(2,n)*sqrt(5); 

    cout<<(a-b)/c;
    return 0;
}
