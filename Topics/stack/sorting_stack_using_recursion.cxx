#include<iostream>
#include<bits/stdc++.h>
using namespace std;


void sortstack(stack<int>&st,int* temp){
	int a;
	if(st.top()<*temp||st.empty()){
		st.push(*temp);
		return;
	}
	a=st.top();
	st.pop();
	sortstack(st,temp);
	st.push(a);
}

void printstack(stack<int>st){
	while(!st.empty()){
		cout<<st.top()<<" ";
		st.pop();
	}
}

int main(){
	stack<int>st;
	int temp;
	cout<<"Enter 5 elements"<<endl;
	for(int i=0;i<2;i++){
		cin>>temp;
		st.push(temp);
	}
	sortstack(st);
	return 0;
}
		
