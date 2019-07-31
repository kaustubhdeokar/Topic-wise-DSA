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
        totalPairs(ans,t,ar,sum-ar[index],index+1);
        index+=1;
        t.pop_back();
    }


}

vector<vector<int>> combinationSum(vector<int>ar,int sum){

    sort(ar.begin(),ar.end());
    vector<vector<int>>answer;
    vector<int>tempanswer;
    totalPairs(answer,tempanswer,ar,sum,0);
    sort(answer.begin(),answer.end());
    vector<vector<int>>ans;
    answer.erase(unique(answer.begin(),answer.end()),answer.end());
    return answer;
}

int main() 
{ 
    vector<int> ar; 
    ar.push_back(10); 
    ar.push_back(1); 
    ar.push_back(2); 
    ar.push_back(7); 
    ar.push_back(6); 
    ar.push_back(1); 
    ar.push_back(5); 
    int n = ar.size(); 
    
    int sum = 8;  
    vector<vector<int> > res = combinationSum(ar, sum); 
    for(int i=0;i<res.size();i++){
        for(int j=0;j<res[i].size();j++){
            cout<<res[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}