//this is the code for longest bitonic subsequence
//this takes the maximum of longest increasing subsequence from left and right
#include<iostream>
#include<bits/stdc++.h>
#define maximum 1000
using namespace std;


int main(){

    int arr[]={1,11,2,10,4,5,2,1};
    int n=sizeof(arr)/sizeof(arr[0]);
    int lis[n];
    int lds[n];
    for(int i=0;i<n;i++){
        lis[i]=1;
        lds[i]=1;
    }
    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(arr[j]<arr[i])
                lis[i]=max(lis[j]+1,lis[i]);
        }
    }

    for(int i=n-2;i>=0;i--){
        for(int j=n-1;j>i;j--){
            if(arr[i]>arr[j])
            lds[i]=max(lds[i],lds[j]+1);
        }
    }
    int maxi=-1;
    for(int i=0;i<n;i++){
        if((lis[i]+lds[i])>maxi)
            maxi=lis[i]+lds[i]-1;
    }
    cout<<maxi<<" ";
    return 0;
}