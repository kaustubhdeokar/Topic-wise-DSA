#include<bits/stdc++.h>
using namespace std;
#define max(a,b) ((a>b)?a:b)

int lcs(string s1,string s2,int n,int m){
	if(n==0 || m==0)
		return 0;
	else if(s1[n-1]==s2[m-1])
		return 1+lcs(s1,s2,n-1,m-1);
	else
		return max(lcs(s1,s2,n-1,m),lcs(s1,s2,n,m-1));
}

int main(){
	int t;
	cin>>t;
	while(t--){
		int n,m;
		cin>>n>>m;
		string s1,s2;
		cin>>s1>>s2;
		cout<<lcs(s1,s2,n,m);
	}
	return 0;
}


