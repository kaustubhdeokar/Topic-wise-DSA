#include<iostream>
#include<bits/stdc++.h>
using namespace std;

template<class X> void print(X a){
	
	for(auto x:a){
		cout<<x<<" ";
	}
}

template <class Y> void front(Y a){
	cout<<a.front();
}

template<class X> X sorted(X a){
	
	a.reverse();
	return a;
}

template<class X> void find(X a){

	for (auto x:a){
		if(x)
	}

}

int  main(){

	list<string> l;
	string temp;
	string arr[5];
	map<string,int>m;
	int f;
	for(int i=0;i<5;i++){
		getline(cin,temp);
		arr[i]=temp;
		f=temp.find(' ');
		temp=temp.substr(0,f);
		l.push_back(temp);
	}
	
	for(int i=0;i<5;i++){
		temp=arr[i];
		f=temp.find(' ');
	}


	
	return 0;

}

