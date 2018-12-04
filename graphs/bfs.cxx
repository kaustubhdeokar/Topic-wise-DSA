#include<iostream>
#include<queue>
using namespace std;

struct node{
	int data;
	struct node* left=NULL;
	struct node* right=NULL;
};

struct node* newnode(int idata){
	struct node* temp=(struct node*)malloc(sizeof(struct node));
	temp->data=idata;
	temp->left=NULL;
	temp->right=NULL;
	return temp;
}
	
void bfs(struct node*head){
	struct node* current;
	queue<struct node*> q;
	q.push(head);
	while(!q.empty()){
		current=q.front();
		cout<<current->data;
		if(current->left!=NULL)
		q.push(current->left);
		if(current->right!=NULL)
		q.push(current->right);
		q.pop(); 
	}
	
}
void traverse(struct node*head){
	if (head==NULL)
	return;
	else
	{
		traverse(head->left);
		cout<<head->data;
		traverse(head->right);
	}
}
int main(){
	cout<<"enter the num. of nodes"<<endl;
	struct node* one=newnode(0);
	struct node* two=newnode(1);
	struct node* three=newnode(2);
	struct node* four=newnode(3);
	one->left=two;
	one->right=three;
	two->right=four;
	three->left=four;
	bfs(one);
	return 0;
}
