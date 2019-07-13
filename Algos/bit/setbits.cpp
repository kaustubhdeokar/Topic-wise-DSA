#include <iostream>
#include<bits/stdc++.h>
using namespace std;

void subsets(string s,string prefix){
	if(s=="")
	cout<<prefix<<endl;
	else if(prefix!="")
	cout<<prefix<<endl;
	else
	{
		for(int i=0;i<s.length();i++){
			string rem=s.substr(0,i)+s.substr(i+1);
			subsets(rem,prefix+s.at(i));
		}
	}
}

int main() {
	
	vector<int>arr;
	arr.push_back(1);
	arr.push_back(2);
	arr.push_back(3);
	string s;
	for(int i=0;i<arr.size();i++)
	s+=to_string(arr[i]);
	subsets(s,"");	
 	return 0;
}
