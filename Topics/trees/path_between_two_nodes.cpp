#include <bits/stdc++.h> 
using namespace std; 

struct Node { 
    int data; 
    Node *left, *right; 
}; 
  
struct Node* getNode(int data) 
{ 
    struct Node* newNode = new Node; 
    newNode->data = data; 
    newNode->left = newNode->right = NULL; 
    return newNode; 
} 

bool getpath(Node* root,vector<int>&path1,int n1){
    if(!root)
    return false;
    path1.push_back(root->data);
    if(root->data==n1)
        return true;
    if(getpath(root->left,path1,n1)||getpath(root->right,path1,n1))
        return true;
    
    path1.pop_back();
    return false;

}


void printPathBetweenNodes(Node* root,int n1,int n2){

    vector<int>path1;
    vector<int>path2;
    getpath(root,path1,n1);
    for(auto x:path1)
    cout<<x<<" ";
    cout<<endl;
    getpath(root,path2,n2);
    for(auto x:path2)
    cout<<x<<" ";

    int i=0,j=0;
    while(i==j && path1[i]==path2[j]){
        i++;
        j++;
    }    
    cout<<endl;
    for(int k=path1.size()-1;k>=i;k--)
    cout<<path1[k];
    for(int k=j-1;k<path2.size();k++)
    cout<<path2[k];
}


int main() 
{ 
    // binary tree formation 
    struct Node* root = getNode(0); 
    root->left = getNode(1); 
    root->left->left = getNode(3); 
    root->left->left->left = getNode(7); 
    root->left->right = getNode(4); 
    root->left->right->left = getNode(8); 
    root->left->right->right = getNode(9); 
    root->right = getNode(2); 
    root->right->left = getNode(5); 
    root->right->right = getNode(6); 
  
    int node1 = 3; 
    int node2 = 5; 
    printPathBetweenNodes(root, node1, node2);
  
    return 0; 
} 
