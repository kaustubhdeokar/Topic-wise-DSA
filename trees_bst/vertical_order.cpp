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

void levelordertraversal(Node* head,int size){
    
	map<int,int>um;
	queue<Node*>q;
	q.push(head);
	um[head->data]=0;
	while(!q.empty()){
		Node* temp=q.front();
		if(temp->left)
		{
			q.push(temp->left);
			um[temp->left->data]=um[temp->data]-1;
		}
		if(temp->right){
			q.push(temp->right);
			um[temp->right->data]=um[temp->data]+1;
		}
		q.pop();
	}
	for(auto x:um){
		cout<<x.first<<" "<<x.second<<endl;
	}

}

/*
7
5 3 7 1 4 6 8
*/
int main(){
	Node *head=NULL;
	int n;
	cin>>n;
	int temp,i;
	for(i=0;i<n;i++){
		cin>>temp;
		head=placeNode(head,temp);
	}
    levelordertraversal(head,n);
	
    return 0;
}

