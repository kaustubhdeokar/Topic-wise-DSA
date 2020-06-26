#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main(){
	multimap<int,string>mp;
	int i,n,no;
	cout<<cbrt(8)-round(8);
	string name;
	cin>>n;
	for(i=0;i<n;i++)
	{
		cin>>no>>name;
		mp.insert({no,name});
	}
	int q;
	cin>>q;
	multimap<int,int>::iterator it;
	for(i=0;i<q;i++)
	{
		cin>>no;
		auto it=mp.find(no);
		cout<<it->second<<endl;
	}
	return 0;
*/
}
