#include<iostream>
#include<bits/stdc++.h>
using namespace std;

//this is problem of long.incr.SUBSEquence ..not necessarily contiguous

int main(){

    int arr[]={10,22,9,33,21,50,41,60};
    int i,j;
    int n=sizeof(arr)/sizeof(arr[0]);
    int longest_ending_here[n+1];
    for(int i=0;i<=n;i++)
    longest_ending_here[i]=1;
    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(arr[j]<arr[i]){
                longest_ending_here[i]=max(longest_ending_here[j]+1,longest_ending_here[i]);
            }
        }
    }

    for(int i=0;i<n;i++)
    cout<<longest_ending_here[i]<<" ";

    return 0;
}