#include<iostream>
#include<bits/stdc++.h>
using namespace std;

void func(int arr[],int data[],int start,int end,int index,int r,int target){
    if(index==r){
        int sum=0;
        for(int j=0;j<r;j++)
        sum+=data[j];
        if(sum==target)
        cout<<"yes"<<endl;
        return;
    }
    for(int i=start;i<=end && end-i+1>=r-index;i++){
        data[index]=arr[i];
        func(arr,data,start+1,end,index+1,r,target);
    }
}

int main(){

    int k,n;
    cin>>k>>n;
    int arr[n];
    for(int i=1;i<=n;i++)
        arr[i]=i;
    int data[k]={0};
    vector<vector<int>>ans;
    func(arr,data,0,n-1,0,k,n);


}