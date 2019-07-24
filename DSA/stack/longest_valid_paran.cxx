#include<iostream>
#include<bits/stdc++.h>
using namespace std;

bool checkbalanced(string s){
	
	stack<char>st;
	int l=s.length();
	for(int i=0;i<l;i++){
		if(s[i]=='(' || s[i]=='{' || s[i]=='[')
		st.push(s[i]);
		else if(s[i]==')'){
			if(st.empty() || st.top()!='(')
			return false;
			else
			st.pop();
		}
		else if(s[i]==']'){
			if(st.empty() || st.top()!='[')
			return false;
			else
			st.pop();
		}
		else if(s[i]=='}'){
			if(st.empty() || st.top()!='{')
			return false;
			else
			st.pop();
		}
	}
	if(st.size()==0)
	return true;
	else
	return false;
}


int main(){
	
	string s;
	cin>>s;
	int maxlen=-1;
	int len=0;
	int l=s.length();
	for(int i=0;i<l;i++){
		for(int j=i+1;j<l;j++){
			if(checkbalanced(s.substr(i,j)))
			{
				len=(j-i+1);
				if(len>maxlen)
				maxlen=len;
			}
		}
	}
	cout<<maxlen<<endl;
	return 0;
}
	
	
			
		
		

