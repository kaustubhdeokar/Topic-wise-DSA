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


Node* insert(Node* head,int idata){
	Node* newnode=new Node(idata);
	if(head==NULL)
		head=newnode;
	else{
		if(idata<head->data)
		head->left=insert(head->left,idata);
		else
		head->right=insert(head->right,idata);
	}
	return head;
}

void inorder(Node* root){
    if(root!=nullptr){
        inorder(root->left); 
        cout << root->data <<" "; 
        inorder(root->right);
    }
    return;
}

Node* MakeTree(Node* head,int arr[],int i,int n){
	if(i<n)
	{
		head=new Node(arr[i]);
		head->left=MakeTree(head->left,arr,2*i+1,n);
		head->right=MakeTree(head->right,arr,2*i+2,n);
	}
	return head;
}

int main(){

	Node* head=NULL;
	int arr[] = {1, 2, 3, 4, 5, 6}; 
    int n = sizeof(arr)/sizeof(arr[0]); 
	head=MakeTree(head,arr,0,n);
    inorder(head);
	
}
