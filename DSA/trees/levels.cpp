#include <bits/stdc++.h> 
using namespace std; 

struct Node 
{ 
    struct Node *left, *right; 
    int data; 
}; 
  
Node* newNode(int key) 
{ 
    Node *temp = new Node; 
    temp->data = key; 
    temp->left = temp->right = NULL; 
    return temp; 
} 


void levels(Node* root,unordered_map<int,int>&umap,int level)
{
    if(!root)
    return;
    umap[root->data]=level;
    levels(root->left,umap,level+1);
    levels(root->right,umap,level+1);
}


int main() 
{ 

    Node * root = newNode(1); 
    root->left = newNode(2); 
    root->right = newNode(3); 
    root->left->left = newNode(4); 
    root->left->right = newNode(5); 
    root->right->left = newNode(6); 
    root->right->right = newNode(7); 
    root->right->left->right = newNode(8); 
   
    unordered_map<int,int>umap;
    levels(root,umap,0);

    //umap has all the levels
    return 0; 
} 
