/*
 * this program consists of insertion in a  binary tree
 * height of a binary tree
*/
#include<bits/stdc++.h>
#include<iostream>
using namespace std;

class Node{
	public:
		int data;
		Node* left;
		Node* right;
		Node(int idata){
			this->data=idata;
			this->left=NULL;
			this->right=NULL;
		}
		
};

Node* placeNode(Node* head,int idata){
	Node* temp=new Node(idata);
	
	if(head==NULL)
		head=temp;
		
	else if(head->data > idata)
		head->left=placeNode(head->left,idata);
	
	else
		head->right=placeNode(head->right,idata);
	
	return head;
	
}

void print(Node* root){
	if(root==NULL)
	return;
	else
	{
		print(root->left);
		cout<<root->data<<" ";
		print(root->right);
	}
}

int checkbalanced(Node* head){

	if(head==NULL)
	return 0;
	else{
		int l=checkbalanced(head->left);
		int r=checkbalanced(head->right);
		if(abs(l-r)>1)
		{
			return -1;
		}
		if(l>r)
		return l+1;
		else
		return r+1;
	}
	return 1;
}


int main(){
	Node *head=NULL;
	int n;
	cin>>n;
	int temp,i;
	for(i=0;i<n;i++){
		cin>>temp;
		head=placeNode(head,temp);
	}
	int a=checkbalanced(head);
	cout<<a;
	if(a!=-1)
	cout<<"true";
	else
	cout<<"false";
	return 0;
}
