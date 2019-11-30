#include<iostream>
#include<queue>
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
	
Node* insertnode(Node* head,int idata){
	Node* temp=new Node(idata);
	if(head==NULL)
	head=temp;
	else if(head->data> idata)
	head->left=insertnode(head->left,idata);
	else
	head->right=insertnode(head->right,idata);
	
	return head;
}

void levelorder(Node* root){
	queue<Node*>q;
	q.push(root);
	Node* temp;
	while(!q.empty()){
		temp=q.front();
		cout<<temp->data<<" ";
		if(temp->left!=NULL)
		q.push(temp->left);
		if(temp->right!=NULL)
		q.push(temp->right);
		q.pop();
	}
}

void levelorder2(Node* root,int level){
	if(level==0)
	return;
	else if(level==1)
	{
		cout<<root->data<<" ";

	}
	else
		{
			levelorder2(root->left,level-1);
			levelorder2(root->right,level-1);
		}
	
}



void print(Node* root){
	if(root==NULL)
	return;
	else
	{
		cout<<root->data<<" ";
		print(root->left);
		print(root->right);
	}
}



int main(){
	Node* head=NULL;
	int n,i,temp;
	cout<<"enter n:"<<endl;
	cin>>n;
	for(i=0;i<n;i++)
	{
		cin>>temp;
		head=insertnode(head,temp);
	}
	levelorder2(head,3);
	return 0;
}
	
	
