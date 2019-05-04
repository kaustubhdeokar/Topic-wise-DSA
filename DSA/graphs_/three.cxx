#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main(){

    int i,n,j,k,t,temp;
    cin>>t;
    for(k=0;k<t;k++){
        int arya[n];
        int aryan[n];
        vector<int> aryav[n*n],aryanv[n*n];
        for(i=0;i<n;i++)
        {
            cin>>arya[i];
            aryav[i].push_back(arya[i]);
            if(i!=0)
            aryav[0].push_back(arya[i]);
        }
        for(j=0;j<n;j++){
            cin>>aryan[j];
            aryanv[i].push_back(aryan[i]);
            if(i!=0)
            aryanv[0].push_back(aryan[i]);
 
        }

        for(i=0;i<n;i++){
            for(j=0;j<sizeof(aryav[i]);j++){
                cout<<aryav[i][j]<<" ";
            }
            cout<<endl;
        }
        for(i=0;i<n;i++){
            for(j=0;j<sizeof(aryanv[i]);j++){
                cout<<aryanv[i][j]<<" ";
            }
            cout<<endl;
        }


    }

}