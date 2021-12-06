#include<math.h>
#include<bits/stdc++.h>
#include<iostream>
#define ll long long
using namespace std;

int main(){

 int t;
 cin>>t;
 while(t){
   unsigned long long int n;
   cin>>n;
   if(n==1)
   cout<<"YES";
   else if(ceil(log2(n))==floor(log2(n)))
   cout<<"YES";
   else
   cout<<"NO";
   cout<<endl;
   t--;
 }
  return 0;
 
}

