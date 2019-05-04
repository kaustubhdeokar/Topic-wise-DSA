#include <iostream>
#include<bits/stdc++.h>
#include<set>
#include<cmath>
#include<stdio.h>
using namespace std; 
#define ll long long
ll numcount=0;
//program for xor 1 to n ...(1^2^3...^n)
int main() { 

int n;
cin>>n;
if(n%4==0)
cout<<n;
else if(n%4==2)
cout<<n+1;
else if(n%4==3)
cout<<0;
else if(n%4==1)
cout<<1;
return 0;
} 
