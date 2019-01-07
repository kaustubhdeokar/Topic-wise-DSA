#include<iostream>
#include<string>
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

Node* insertNode(string s,Node* root,int idata){

	int l=s.size();
	Node* temp=new Node(idata);
		if(s[0]=='\0')
		root=temp;
		else if(s[0]=='L')	
		root->left=insertNode(s.substr(1,l),root->left,idata);
		else
		root->right=insertNode(s.substr(1,l),root->right,idata);

	return root;	
}

void print(Node* root){
	if(root==NULL)
	return;
	else
	{
		cout<<root->data;
		print(root->left);
		print(root->right);
	}
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
	
int diameter(Node* root){
	int h1=height(root->left);
	int h2=height(root->right);
	return h1+h2+1;
}

int main(){
	Node* root=NULL;
	int i,n,rootdata;
	cin>>n>>rootdata;
	root=new Node(rootdata);
	int j;
	string s,key;
	int numbers[n-1];
	string arrs[n-1];
	for(i=0;i<n-1;i++)
		cin>>arrs[i]>>numbers[i];
	
	for(i=0;i<n-1;i++)
	{
		if(i>0){
			key=arrs[i];
			j=i-1;
			while(j>=0 && (arrs[j].size()>key.size()))
			{
				arrs[j+1]=arrs[j];
				j--;
			}
			arrs[j+1]=key;
		}
	}		
	
	
	for(i=0;i<n-1;i++)
	{
	 root=insertNode(arrs[i],root,numbers[i]);
	}
	int d=diameter(root);
	int dleft=diameter(root->left);
	int dright=diameter(root->right);
	
	if(d>dleft && d>dright)
	cout<<d;
	else if(dleft>dright && dleft>d)
	cout<<dleft;
	else
	cout<<dright;
	
	return 0;
}
