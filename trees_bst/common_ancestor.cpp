#include<bits/stdc++.h>
#include<iostream>
using namespace std;

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

void descendant(Node* head,int data1,int data2){
	
	if(head==nullptr)
	{
		cout<<"null-returned"<<endl;
		return;
	}
	if(head->data > data1 && head->data> data2)
	{
	//	cout<<"both smaller"<<head->data<<endl;
		descendant(head->left,data1,data2);
	}
	else if(head->data < data1 && head->data < data2)
	{
	//	cout<<"both greater"<<head->data<<endl;
		descendant(head->right,data1,data2);
	}
	else if (head->data>data1 && head->data<data2)
	{
		cout<<"middle"<<head->data<<endl;
	}
	else if(head->data== data1 || head->data==data2)
	{
		cout<<head->data;
		return;
	}
	
	
}

int main(){
	
	Node* head=nullptr;
	int temp,nodes;
	cin>>nodes;
	while(nodes){
		cin>>temp;
		head=push(head,temp);
		nodes-=1;
	}
	int data1,data2;
	cout<<"enter the data of which parent u wanna find"<<endl;
	cin>>data1>>data2;
	descendant(head,data1,data2);
	return 0;
}

