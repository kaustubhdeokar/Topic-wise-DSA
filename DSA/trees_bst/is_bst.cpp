#include<iostream>
#include<cstdint>
#include<limits.h>
using namespace std;
#define max(a,b) (a<b?b:a)
int min=INT_MAX;
int max=INT_MIN;
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
// first we see that minimum of the right subtree is greate than the root node 
// then we see that the maximum of the left subtree is smaller than the root node 
Node* isbst(Node* root){

}

Node* insert(Node* root,int data){

    Node* newnode=new Node(data);
    if(root==NULL)
    root=newnode;
    else if(data< root->data)
    root->left=insert(root->left,data);
    else
    root->right=insert(root->right,data);
    return root;
}

int height(Node* root){

    if(root==NULL)
    return -1;
    int left=height(root->left)+1;
    int right=height(root->right)+1;
    return max(left,right);
}



int main(){
    int n,i;
    Node* root=NULL;
    cin>>n;
    for(i=0;i<n;i++)
    {
        int temp;
        cin>>temp;
        root=insert(root,temp);
    }
    int h=height(root);
    cout<<h;
}
