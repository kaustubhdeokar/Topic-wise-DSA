#include<iostream>
#include<vector>
#include<bits/stdc++.h>
using namespace std;


int main(){
		
	set<int>q;
	q.insert(2);
	q.insert(2);
	q.insert(3);
	q.insert(3);
	q.insert(2);
	q.insert(2);
	q.insert(5);	
	cout<<q.size();
	return 0;
}
	
	
