
//minimum number of operations required to convert string 1 to string 2

//1. insert 
//2. delete
//3. modify

#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main(){


    //bottom up manner.

    string s1="march";
    string s2="cart";
    int n=s1.length();
    int m=s2.length();
    int answer[n+1][m+1];

    for(int i=0;i<=n;i++)
        answer[i][0]=i;

    for(int i=0;i<m;i++)
    answer[0][i]=i;

for(int i=1;i<=n;i++){
    for(int j=1;j<=m;j++){
        if(s1[i-1]==s2[j-1])
            answer[i][j]=answer[i-1][j-1];
        else
            answer[i][j]=min(answer[i-1][j],min(answer[i][j-1],answer[i-1][j-1]))+1;
    }
}

    cout<<answer[n][m];

    return 0;
}