#include<iostream>
#include<bits/stdc++.h>
using namespace std;

string replaceall(string s,string toreplace,string replaceby){
	
	size_t pos=s.find(toreplace);
	while(pos!=string::npos){
		s.replace(pos,toreplace.size(),replaceby);
		pos=s.find(toreplace,pos+replaceby.size());
	}
	return s;
}

int main(){
	string s="1 multiply 2 multiply 3 add 4 subtract 5";

	s=replaceall(s,"multiply","*");
	s=replaceall(s,"divide","/");
	s=replaceall(s,"subtract","-");
	s=replaceall(s,"add","+");

	cout<<s;
	return 0;
}
