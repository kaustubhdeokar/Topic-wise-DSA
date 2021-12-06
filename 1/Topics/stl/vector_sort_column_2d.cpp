#include<iostream>
#include<bits/stdc++.h>
using namespace std;

bool sortbycol(const vector<int>&v1,const vector<int>&v2){
    return v1[1]<v2[1];
}

int main(){

    vector<vector<int>>vect{{3, 5, 1},{4, 8, 6},{7, 2, 9}};

    sort(vect.begin(),vect.end(),sortbycol);

    for(int i=0;i<vect.size();i++){
        for(int j=0;j<vect[i].size();j++){
            cout<<vect[i][j]<<" ";
        }
        cout<<endl;
    }
}