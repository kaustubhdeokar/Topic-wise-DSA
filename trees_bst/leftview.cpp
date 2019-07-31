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

void leftview(Node* head,int level,int* maxlevel){

    if(head==nullptr)
    return;
    if(level>*maxlevel){
        *maxlevel=level;
        cout<<head->data;
    }
    leftview(head->left,level+1,maxlevel);
    leftview(head->right,level+1,maxlevel);
}

void leftview(Node* head){

    int maxlevel=0;
    int level=1;
    leftview(head,1,&maxlevel);    

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
    leftview(head);
	
    return 0;
}

