#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Node{
    public:    
    int data;
    Node* left;
    Node* right;
    Node(){}
    Node(int x){
        data=x;
        left=NULL;
        right=NULL;
    }
};

void traverse(Node* head){
    if(head==NULL)
    return;
    else{
        cout<<head->data<<" ";
        traverse(head->left);
        traverse(head->right);
    }
}

Node* maketree(Node* head,int arr[],int i,int high){
    if(i<high){
        head=new Node(arr[i]);
        head->left=maketree(head->left,arr,i*2+1,high);
        head->right=maketree(head->right,arr,2*i+2,high);
    }
    return head;
}

Node* lca(Node* head,int n1,int n2){

    if(!head) return NULL;
    
    if(head->data==n1 || head->data==n2)
        return head;
    
    Node* left=lca(head->left,n1,n2);
    Node* right=lca(head->left,n1,n2);

    if(left && right)  return head;
    return (left!=NULL)?left:right;

}

int main(){
    Node * root = new Node(1); 
    root->left = new Node(2); 
    root->right = new Node(3); 
    root->left->left = new Node(4); 
    root->left->right = new Node(5); 
    root->right->left = new Node(6); 
    root->right->right = new Node(7); 
    cout << "LCA(4, 5) = " << lca(root, 4, 5)->data; 
    return 0;
}