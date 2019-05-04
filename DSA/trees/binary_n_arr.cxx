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
			print(root->left);
			cout<<root->data;
			print(root->right);
		}
}

int height(Node* root){
	if(root==NULL)
	return -1;
	int ldepth,rdepth;
	ldepth=height(root->left);
	rdepth=height(root->right);
	if(ldepth>rdepth)
	return ldepth+1;
	else
	return rdepth+1;
	
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
	print(head);
	int h=height(head);
	cout<<endl<<"height is:"<<h;
	return 0;
}
