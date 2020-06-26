#include <iostream>
#include <cstdlib>
#include <bits/stdc++.h>
using namespace std;

int ternary_search(int a[],int l,int n,int key){
	int low=l,high=n;
	int mid1=low+(high-low)/3;
	int mid2=high-((high-low)/3);
	if(a[mid1]==key)
		return mid1;
	else if(a[mid2]==key)
		return mid2;
	else if(a[mid1]>key)
		return ternary_search(a,l,mid1,key);
	else if(a[mid2]<key)
		return ternary_search(a,mid2,high,key);
		
	else
		return ternary_search(a,mid1+1,mid2+1,key);
}

int main(int argc, char **argv)
{
	int n,i,ans;
	cin>>n;
	int a[n];
	for(i=0;i<n;i++)
		cin>>a[i];
	sort(a,a+n);
	int q;
	cout<<"enter the number of queries"<<endl;
	cin>>q;
	for(i=1;i<=q;i++){
		ans=ternary_search(a,0,n,i);
		cout<<ans<<endl;
	}
	return 0;
}

