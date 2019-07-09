#include<bits/stdc++.h>
using namespace std;
#define max(a,b) ((a>b)?a:b)

void lcs(string s1,string s2,int n,int m){
	
	int mat[n+1][m+1];
	for(int i=0;i<=n;i++)
	{
		for(int j=0;j<=m;j++){
			if(i==0 || j==0)
			mat[i][j]=0;
			else if(s1[i-1]==s2[j-1])
			mat[i][j]=1+mat[i-1][j-1];
			else
			mat[i][j]=max(mat[i-1][j],mat[i][j-1]);
		}
	}	
	cout<<mat[n][m];
}

int main(){
	int t;
	cin>>t;
	while(t--){
		int n,m;
		cin>>n>>m;
		string s1,s2;
		cin>>s1>>s2;
		lcs(s1,s2,n,m);
	}
	return 0;
}


