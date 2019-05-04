#include<iostream>
#include<cstdint>
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
    else if(data< root->data)
    root->left=insert(root->left,data);
    else
    root->right=insert(root->right,data);
    return root;
}
 int minimum;
 int maximum;

void min(Node* root)
{
  if(root==nullptr)
  return;
  else
  {
    minimum=root->data;
    min(root->left);
  }
}

void max(Node* root)
{
  if(root==nullptr)
  return;
  else
  {
    maximum=root->data;
    max(root->right);
  }
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
    max(root);
    cout<<maximum;
}
