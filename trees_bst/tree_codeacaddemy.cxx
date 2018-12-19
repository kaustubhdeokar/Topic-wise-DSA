#include<iostream>
using namespace std;

class bstnode{

	public:
		int data;
		bstnode* left;
		bstnode* right;
	bstnode(int data){
		this->data=data;
		this->left=NULL;
		this->right=NULL;
	}
};
