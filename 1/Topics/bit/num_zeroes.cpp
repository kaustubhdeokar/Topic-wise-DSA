#include <iostream>
#include<bits/stdc++.h>
#include<set>
#include<cmath>
#include<stdio.h>
using namespace std; 
#define ll long long
ll numcount=0;

void count(int n){
    if(n/2!=0)
    count(n/2);

    if(n%2!=0)
   numcount++;
}

void countzeroes(int n,int numcount){

    int ans=0;
    for(int i=0;i<numcount;i++){
        int t=pow(2,i);
        if((t^n)>n)
        {
            ans+=1;
        }
    }
    cout<<ans;

}

int main() { 


int n;
cout<<"enter n:"<<endl;
cin>>n;
count(n);
cout<<numcount<<endl;
//countzeroes(n,numcount);

return 0;
} 
