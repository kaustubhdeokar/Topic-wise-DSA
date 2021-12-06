#include<iostream>
#include<bits/stdc++.h>
#include<cmath>
using namespace std;
#define ull unsigned long long
#define mod 1000000007

void gensubsets(int a[],string s,string prefix){
	if(s=="")
	{
	cout<<prefix<<endl;
	}
	int l=s.length();
	for(int i=0;i<l;i++){
		string rem=s.substr(0,i)+s.substr(i+1);
		if(rem!="")
		cout<<rem<<endl;
		gensubsets(a,rem,prefix+s.at(i));
	}
} 

void subsets(int a[],string s){
	gensubsets(a,s,"");
}

int main(){
	int a[]={1,2,3};
	string s="";
	int n=(sizeof(a)/sizeof(a[0]));
	for(int i=0;i<n;i++)
	s+=to_string(a[i]);
	subsets(a,s);
	return 0;
}

