#include<bits/stdc++.h>
#include<iostream>
using namespace std;

class Node{
	public:
	int data;
	Node* left;
	Node* right;
	Node(int idata){
		data=idata;
		left=NULL;
		right=NULL;
	}
};

Node* maketree(Node* head,int arr[],int i,int end){
		if(i<end){
		head=new Node(arr[i]);
		head->left=maketree(head->left,arr,2*i+1,end);
		head->right=maketree(head->right,arr,2*i+2,end);
		}
	return head;
}

void traverse(Node* head){
	if(head==NULL)
	return;
	else{
		traverse(head->left);
		traverse(head->right);
		cout<<head->data;
	}
}

void iterativepostorder(Node* head){
	
	if(head==NULL)
	return;
	stack<Node*>s1;
	stack<Node*>s2;
	s1.push(head);
	while(!s1.empty()){
		Node* temp=s1.top();
		s1.pop();
		if(temp->left)
		s1.push(temp->left);
		if(temp->right)
		s1.push(temp->right);
		s2.push(temp);
	}
	while(!s2.empty()){
		Node* temp=s2.top();
		cout<<temp->data;
		s2.pop();
	}
}
int main()
{
 
  int arr[]={1,2,3,4,5,6,7};
  int n=sizeof(arr)/sizeof(arr[0]);
  Node* head=NULL;
  head=maketree(head,arr,0,n);
  traverse(head);
  cout<<endl;
  iterativepostorder(head);
  return 0;
}    

