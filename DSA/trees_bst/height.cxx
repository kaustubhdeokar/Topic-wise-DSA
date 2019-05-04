#include<iostream>
#include<set>
#include<cstdint>
using namespace std;
#define max(a,b) (a<b?b:a)

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
    else if(data<= root->data)
    root->left=insert(root->left,data);
    else
    root->right=insert(root->right,data);
    return root;
}

int height(Node* root){

    if(root==NULL)
    return 0;
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
