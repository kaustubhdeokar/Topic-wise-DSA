/*
 * this program consists of insertion in a  binary tree
 * height of a binary tree
*/

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
		cout<<root->data<<endl;
		print(root->left);
		print(root->right);
	}
}

void print(Node* root,int temp){
	
	if(root==NULL)
	return;
	else
		{
			if(root->data==temp){
			cout<<root->data<<endl;
			print(root->left);
			print(root->right);
			}
			else
			{
			print(root->left,temp);
			print(root->right,temp);
			}
		}
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
	cin>>temp;
	print(head,temp);

	return 0;
}
