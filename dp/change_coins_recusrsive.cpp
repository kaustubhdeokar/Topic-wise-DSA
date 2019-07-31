#include<iostream>
#include<bits/stdc++.h>
#define maximum 1000
using namespace std;

void func(vector<int>&arr,int total,int index,vector<int>&temp,vector<vector<int>>&answer){
    cout<<"total:"<<total<<endl;
    if(total<0)
        return;
    if(total==0){
        answer.push_back(temp);
        return;
    }
    while(index<arr.size() && arr[index]<=total){
        temp.push_back(arr[index]);
        func(arr,total-arr[index],index,temp,answer);
        index+=1;
        temp.pop_back();
    }
}


int main(){

    int n,m;
    vector<int>arr={1,2,2,5};
    arr.erase(unique(arr.begin(),arr.end()),arr.end());
    int total=5;
    int index=0;
    vector<vector<int>>answer;
    vector<int>temp;

    func(arr,total,0,temp,answer);

    for(int i=0;i<answer.size();i++){
        for(int j=0;j<answer[i].size();j++){
            cout<<answer[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}