#include<iostream>
#include<stack>
using namespace std;

string isbalanced(string s){
	stack<char>st;
	for(auto c:s){
		switch(c)
		{
			case '{':
			case '(':
			case '[':
			st.push(c);
			break;
			case '}':
			if(st.empty()||st.top()!='{')
			return "NO";
			st.pop();
			break;
			case ')':
			if(st.empty()||st.top()!='(')
			return "NO";
			st.pop();
			break;
			case ']':
			if(st.empty()||st.top()!='[')
			return "NO";
			st.pop();
			break;
		}
	}
	return st.empty()? "YES" : "NO" ;
}
int main(){
	int t;
	cin>>t;
	while(t)
	{
		
		string s;
		cin>>s;
		cout<<isbalanced(s)<<endl;
		t-=1;
	}
	return 0;
}
