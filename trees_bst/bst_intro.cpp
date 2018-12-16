#include<iostream>
using namespace std;

class TreeNode{
	public:
	int data;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int data){
		this->data=data;
		this->left=NULL;
		this->right=NULL;
	}
};

TreeNode* root=NULL;

void insert(int data){

    TreeNode* newnode=new TreeNode(data);
    cout<<root->data;
    cout<<root->left;
    cout<<root->right;
}

	void print(TreeNode* root){
		
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
	
	int n;
	cin>>n;
	int i;
    TreeNode* head;
	for(i=0;i<n;i++)
	{
		int temp;
		cin>>temp;
		head=insert(temp);
	}
	return 0;
}
	
	
