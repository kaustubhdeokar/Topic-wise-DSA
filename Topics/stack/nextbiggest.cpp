#include<iostream>
#include<bits/stdc++.h>
using namespace std;


int main()
{
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		int arr[n];
		int ans[n];
		memset(ans,-1,n*sizeof(int));
		for(int i=0;i<n;i++)
			cin>>arr[i];
		stack<int>s;
		for(int i=n-1;i>=0;i--)
		{
			while(!s.empty() && arr[i]>=s.top())
				s.pop();
			ans[i]=s.empty()?-1:s.top();
			s.push(arr[i]);
		}
		for(int i=0;i<n;i++)
		cout<<ans[i]<<" ";
	}

  return 0;
}


