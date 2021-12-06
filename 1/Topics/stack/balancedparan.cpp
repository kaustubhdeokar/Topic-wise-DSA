#include <iostream>
#include <typeinfo>
using namespace std;
#include<bits/stdc++.h>
int main() {
	int t;
	cin>>t;
	while(t--){
		int temp=1;
		stack<char>stack_;
		string string_;
		cin>>string_;
		int l=string_.length();
		for(int i=0;i<l;i++)
		{
			if(string_[i]=='{' || string_[i]=='[' || string_[i]=='(')
			stack_.push(char(string_[i]));
			else{
				if(stack_.empty())
				{
					temp=0;
					break;
				}
				else{
					char t=stack_.top();
					temp=1;
					if((string_[i]=='}' && t!='{') || (string_[i]==']' && t!='[') || (string_[i]==')' && t!='('))
					{
					temp=0;
					break;
					}
					stack_.pop();
				}
			if(temp==0)break;
			}
		}
		if(temp==0 || (!stack_.empty()))
		cout<<"unbalanced";
		else
		cout<<"balanced";
	}
	return 0;
}

