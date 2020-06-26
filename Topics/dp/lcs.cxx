#include<bits/stdc++.h>
#include<iostream>
#define max(a,b) ((a>b)?a:b)
using namespace std;


int changes(string s1,int n,string s2,int m){
	int arr[n+1][m+1];
	for(int i=0;i<=n;i++){
		for(int j=0;j<=m;j++){
			if(i==0||j==0)
			arr[i][j]=0;
			else if(s1[n-1]==s2[m-1])
			arr[i][j]=1+arr[i-1][j-1];
			else
			arr[i][j]=max(arr[i-1][j],arr[i][j-1]);
		}
	}
	return arr[n][m];
}

int main() {
	int t;
	cin>>t;
	while(t--){
	    int n,m;
	    cin>>n>>m;
	    string s1,s2;
	    cin>>s1>>s2;
	    cout<<changes(s1,n,s2,m);
	}
	return 0;
}

