#include<bits/stdc++.h>
#include<iostream>
using namespace std;

int temp=1;

class Node{
	public:
	int data;
	Node* left;
	Node* right;
	Node(int data){
		this->data=data;
		this->left=nullptr;
		this->right=nullptr;
	}
};
/*
 
 10
 5 3 7 1 4 0 6 8 10 9 
 
 */
Node* push(Node* head,int temp){
		
	Node* newnode=new Node(temp);
	if(head==nullptr)
	head=newnode;
	else if(head->data>temp)
	head->left=push(head->left,temp);
	else
	head->right=push(head->right,temp);
	return head;
}

void here(Node* one,Node* two){

	if(two==nullptr)
	return;
	else{
		if(one->data!=two->data)
		{
			temp=0;
			return;
		}
		here(one->left,two->left);
		here(one->right,two->right);
	}
}
void subtree(Node* one,Node* two){
	
	if(one==nullptr)
	return;
	else{
		if(one->data==two->data)
		{
			here(one,two);
			return;
		}
		subtree(one->left,two);
		subtree(one->right,two);
	}	
}

int main(){
	
	Node *T = new Node(26);  
    T->right = new Node(3);  
    T->right->right = new Node(3);  
    T->left      = new Node(10);  
    T->left->left    = new Node(4);  
    T->left->left->right = new Node(30);  
    T->left->right   = new Node(6);
    
    Node *S = new Node(10);  
    S->right     = new Node(6);  
    S->left  = new Node(4);  
    S->left->right = new Node(30);
	
	subtree(T,S);
	if(temp==1)
	cout<<"S is a subtree of T"<<endl;
	cout<<endl;
	return 0;
}

