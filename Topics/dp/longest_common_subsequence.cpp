#include<iostream>
#include<bits/stdc++.h>
using namespace std;

//this is problem of long.common.subsequence ..not necessarily contiguous

int main(){


    //bottom up manner.

    string s1="aggtab";
    string s2="gxtxayb";

    int n=s1.length();
    int m=s2.length();

    int answer[n+1][m+1];
    for(int i=0;i<=n;i++)
        for(int j=0;j<m;j++)
            answer[i][j]=0;
    string ans="";
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(s1[i-1]==s2[j-1])
                answer[i][j]=1+answer[i-1][j-1];
            else
                answer[i][j]=max(answer[i-1][j],answer[i][j-1]);
        }
    }

    cout<<endl<<answer[n][m]<<endl;
    return 0;
}