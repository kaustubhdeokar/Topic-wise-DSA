#include<iostream>
using namespace std;

class Node{

    public:
        int data;
        Node* left;
        Node* right;
    Node(int data){
        this->data=data;
        this->left=NULL;
        this->right=NULL;
    }
};

Node* insert(Node* root,int data){

    Node* newnode=new Node(data);
    if(root==NULL)
    root=newnode;
    else if(data < (root->data))
		root->left=insert(root->left,data);
    else    
        root->right=insert(root->right,data);
    return root;
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

int main(){
	Node* root=NULL;
    int n,i;
    cin>>n;
    for(i=0;i<n;i++)
    {
        int temp;
        cin>>temp;
        root=insert(root,temp);
		print(root);
    }
    return 0;
}
