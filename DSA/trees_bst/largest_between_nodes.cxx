#include<iostream>
#include<queue>
#include<limits.h>
#define max(a,b) if(a>b)? a:b
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

int findright(Node* head,int r,int longest){
	
	if(head->data > longest)
	longest=head->data;
	
	if(r > head->data)
	findright(head->right,r,longest);
	else if(r < head->data)
	findright(head->left,r,longest);
	else
	return longest;
}

void find(Node* head,int l,int r){
	long long int longest=INT_MIN;
	long long int ans;
	if(head->data >l && head->data < r)
		ans=findright(head,r,longest);
	else if(head->data > l && head->data > r)
		{
			find(head->left,l,r);
			return;
		}
	else if(head->data < l && head->data < l)
		{
			find(head->right,l,r);
			return;
		}
	else if(head->data ==l && r < head->data)
		ans=head->data;
	else if(head->data ==l && r> head->data)
		ans=findright(head,r,longest);
	else if(head->data ==r && l<head->data)
		ans=head->data;
	else if(head->data==r && l>head->data)
		ans=findright(head,l,longest);
	cout<<ans;	
}

int main(){
	Node* head=NULL;
	long long int l,r,n,temp,i;
	cin>>n;
	for(i=0;i<n;i++)
	{
		cin>>temp;
		head=insertnode(head,temp);
	}
	cin>>l>>r;
	find(head,l,r);
	
	return 0;
}
	
	
