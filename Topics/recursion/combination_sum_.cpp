#include<iostream>
#include<bits/stdc++.h>
using namespace std;

void totalPairs(vector<vector<int>>&ans,vector<int>t,vector<int>ar,int sum,int index){

    if(sum<0)
    return;
    if(sum==0){
        ans.push_back(t);
    }
    while(index<ar.size() && sum-ar[index]>=0){
        t.push_back(ar[index]);
        totalPairs(ans,t,ar,sum-ar[index],index);
        index+=1;
        t.pop_back();
    }


}

vector<vector<int>> combinationSum(vector<int>ar,int sum){

    sort(ar.begin(),ar.end());
    ar.erase(unique(ar.begin(),ar.end()),ar.end());
    vector<vector<int>>answer;
    vector<int>tempanswer;
    totalPairs(answer,tempanswer,ar,sum,0);
    cout<<"size:answer"<<answer.size()<<endl;
    return answer;
}

int main() 
{ 
    vector<int> ar; 
    ar.push_back(2); 
    ar.push_back(4); 
    ar.push_back(6); 
    ar.push_back(8); 
    int n = ar.size(); 
    cout<<"eh";
    int sum = 8; // set value of sum 
    vector<vector<int> > res = combinationSum(ar, sum); 
    for(int i=0;i<res.size();i++){
        for(int j=0;j<res[i].size();j++){
            cout<<res[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}