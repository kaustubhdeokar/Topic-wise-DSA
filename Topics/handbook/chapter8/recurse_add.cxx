#include<iostream>
#include<bits/stdc++.h>
#include<cmath>
using namespace std;
#define ull unsigned long long
#define mod 1000000007

int add(int a,int b){
	if(b==0 || b==1)
	return a;
	else
	return a+add(a,b-1);
	
}

int main(){
	int a,b;
	cin>>a>>b;
	cout<<add(a,b);
	return 0;
}

