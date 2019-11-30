#include<iostream>
#include<cmath>
#include<bits/stdc++.h>
using namespace std;

int main(){
int n,k;
cin>>n>>k;
int arr[n];
for(int p=0;p<n;p++)
cin>>arr[p];
sort(arr,arr+n);
int count=0;
int temp;
if(k>n)
temp=n/2;
else 
temp=k;
for(int i=0;i<temp;i++)
count+=arr[n-i-1]-arr[i];
cout<<count;
return 0;
}