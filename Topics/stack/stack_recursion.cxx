#include<iostream>
#include<bits/stdc++.h>
using namespace std;

void print(stack<int>&st){
		int a;
		if(!st.empty()){
			a=st.top();
			st.pop();
			print(st);
			cout<<a<<" ";
		}
		else
		return;	
	
}

int main(){
	stack<int>st;
	int n,temp;
//	cout<<"enter number of elements"<<endl;
	cin>>n;
//	cout<<"enter n elements"<<endl;
	for(int i=0;i<n;i++){
		cin>>temp;
		st.push(temp);
	}
	print(st);

	return 0;
}
