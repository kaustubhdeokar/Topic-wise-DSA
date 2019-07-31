#include<bits/stdc++.h>
using namespace std;
#define bits 16

int t=0;

int numberofpathsdp(int n,int m){

	int result[n][m];
	for(int i=0;i<n;i++)
	result[i][0]=1;
	for(int j=0;j<m;j++)
	result[0][j]=1;

	for(int i=1;i<n;i++){
		for(int j=1;j<m;j++){
			result[i][j]=result[i-1][j]+result[i][j-1];
		}
	}
	for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
		cout<<result[i][j]<<" ";
		}
		cout<<endl;
	}
	return result[n-1][m-1];
}

int main(){
	int n,m;
	cin>>n>>m;
	cout<<numberofpathsdp(n,m);
	return 0;
}


