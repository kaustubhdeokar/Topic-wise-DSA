/* this program calculates the power in logn */
#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int power(int x, unsigned int y) 
{ 
    int temp;
    if (y == 0) 
        return 1; 
    temp=power(x,y/2);
    if(y%2==0)
    return power(x,y/2)*power(x,y/2);
    else
    return x*power(x,y/2)*power(x,y/2);
} 

bool SchoolsPrime(int n){

    if(n<=1)return false;
    if(n<=3)return true;
    if(n%2==0 || n%3==0)
    return false;
    for(int i=5;i*i<=n;i+=6){
        if((n%i==0)||(n%(i+2)==0))
        return false;
        }
    return true;
}

int fact(int i){
    
}

bool WilsonsPrime(int n){
    //(p-1)!%p=-1;
}

int main(){

    cout<<power(2,4);
    return 0;
}
