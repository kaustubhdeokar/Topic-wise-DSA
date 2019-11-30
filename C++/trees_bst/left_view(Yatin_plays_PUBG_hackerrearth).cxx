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


int height(Node* root){
	int ldepth,rdepth;
	
	if(root==NULL)
	return 0;

	ldepth=height(root->left);
	rdepth=height(root->right);

	if(ldepth>rdepth)
		return ldepth+1;
	else
		return rdepth+1;
	}



int main(){
	Node* head=NULL;
	int t;
	cin>>t;
	while(t--){
	int n,i,temp;
	cin>>n;
	for(i=0;i<n;i++)
	{
		cin>>temp;
		head=insertnode(head,temp);
	}
	
	int h=0;
	h=height(head);
	cout<<h<<endl;
	}
	return 0;
}
	
	
