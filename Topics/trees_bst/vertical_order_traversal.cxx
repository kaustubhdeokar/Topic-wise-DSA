#include<iostream>
#include<queue>
using namespace std;

class Tree{
	public:
		int data;
		int count=0;
		Tree* left;
		Tree* right;
		Tree(int data)
	{
		this->data=data;
		this->left=NULL;
		this->right=NULL;
	}
};

Tree* insertnode(Tree* root,int data){
	
	Tree* newnode=new Tree(data);
	if(root==NULL)
		root=newnode;
		
	else if(root->data > data)
		root->left=insertnode(root->left,data);
	
	else
		root->right=insertnode(root->right,data);
	
	return root;
		
}

void levelorder(Tree* root){
	Tree* temp;
	queue<Tree*> q;
	q.push(root);
	while(!q.empty())
	{
		temp=q.front();
		cout<<temp->data<<" ";
		if(temp->left!=NULL)
		{
			q.push(temp->left);
		}
		if(temp->right!=NULL)
		{
			q.push(temp->right);
		}
		q.pop();
	}	
}


void print(Tree* root){
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
	Tree* root=NULL;
	int n,i;
	cin>>n;
	int temp;
	for(i=0;i<n;i++)
	{
		
		cin>>temp;
		root=insertnode(root,temp);
	}
	levelorder(root);
return 0;
}
