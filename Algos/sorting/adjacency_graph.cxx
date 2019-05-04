#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main(){
	vector <int> v,v1;
	int i;
	for(i=0;i<5;i++)
	v.push_back(i);
	cout<<"this  is the first vector"<<endl;
	for(auto i=v.begin();i!=v.end();i++)
	cout<<*i;
	cout<<endl;
	//using v.at
	//for(i=0;i<v.size();i++)
	//cout<<v.at(i);
	//can also use directly v[i] if used i

	cout<<endl;
	v1.assign(5,10);
	cout<<"this  is the second vector"<<endl;
	for(auto i=v1.begin();i!=v1.end();i++)
	cout<<*i<<" ";
	cout<<endl;
	//here we erased the first position 1
	//v.erase(v.begin()+1);
	cout<<"after swapping"<<endl;
	v.swap(v1);
	cout<<"this  is the first vector"<<endl;
	for(auto i=v.begin();i!=v.end();i++)
	cout<<*i<<" ";
	cout<<"this  is the second vector"<<endl;
	for(auto i=v1.begin();i!=v1.end();i++)
	cout<<*i<<" ";
	
	return 0;

}
