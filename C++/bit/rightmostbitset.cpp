#include<math.h>
#include<bits/stdc++.h>
#include<iostream>
#define ll long long
using namespace std;

void firstsetbit(int n){
   if(n==0)
   cout<<0;
   else
   cout<<log2(n&-n)+1;
   cout<<endl;
}

int main(){

 int t;
 cin>>t;
 while(t){
   int n,m;
   cin>>n>>m;
   int a=n^m;
   firstsetbit(a);
   t--;
 }
  return 0;
 
}

