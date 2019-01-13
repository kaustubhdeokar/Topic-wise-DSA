#include<bits/stdc++.h>
using namespace std;

class Node{
	int data;
	int color;
	Node* left;
	Node* right;

	Node(int idata,int icolor){
		data=idata;
		color=icolor;
		left=NULL;
		right=NULL;
	}
};

	
int main(){
	int n,c;
	int i,temp;
	for(i=0;i<n;i++){
		cin>>color;
		
		
