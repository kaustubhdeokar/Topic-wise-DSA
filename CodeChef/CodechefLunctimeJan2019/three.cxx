#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main(){

    int i,n,j,k,t,temp;
    cin>>t;
    for(k=0;k<t;k++){
		cin>>n;
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
            aryanv[n-j-1].push_back(aryan[j]);
            if(j!=n-1)
            aryanv[n-1].push_back(aryan[j]);	
 
        }

        for(i=0;i<n;i++){
			cout<<"i is:"<<i<<endl;
            for(j=0;j<aryav[i].size();j++){
                cout<<aryav[i][j]<<" ";
            }
            cout<<endl;
        }
        for(i=0;i<n;i++){
			cout<<"i is:"<<i<<endl;
            for(j=0;j<aryanv[i].size();j++){
                cout<<aryanv[i][j]<<" ";
            }
            cout<<endl;
        }


    }

}
